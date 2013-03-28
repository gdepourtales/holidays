/*
 * Copyright (C) 2013  Guy de Pourtalès
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.gadp.holidays;

import org.joda.time.DateMidnight;
import org.jruby.RubyArray;
import org.jruby.RubyHash;
import org.jruby.RubySymbol;
import org.jruby.embed.InvokeFailedException;
import org.jruby.embed.LocalContextScope;
import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;
import org.jruby.ext.jruby.JRubyUtilLibrary;
import org.jruby.util.io.InvalidValueException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Holidays calculation API. Actually this class wraps the Ruby Holidays Gem module and exposes equivalent methods in
 * the Java world. Holidays API embeds the API and uses JRuby to execute the Holidays GEM.
 */
public class Holidays {

    /**
     * When used in options, denote a standard official holiday
     */
    public static final byte NO_OPTION = 0;
    /**
     * When used in options, selects informal holidays
     */
    public static final byte INFORMAL = 1;
    /**
     * When used in options, selects observed holidays
     */
    public static final byte OBSERVED = 2;

    /**
     * The main holidays rub script source resource
     */
    private static final String SCRIPTING_PATH = "holidays.rb";
    /**
     * Path to the automatically build list of resource files
     */
    private static final String REGIONS_PATH = "holidaydefs";

    /**
     * Available regions loaded during this class instantiation
     */
    private final List<String> availableRegions = new ArrayList<String>();

    /**
     * The JRuby container executing the required scripts.
     * The container is defined as threadsafe and persistent to allow several Holidays instances to be loaded
     */
    private final ScriptingContainer jrubyContainer = new ScriptingContainer(LocalContextScope.THREADSAFE, LocalVariableBehavior.PERSISTENT);
    /**
     * Date parser for custom RubyObject returned by the Holidays Gem
     */
    private final SimpleDateFormat rubyDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * Loads the content of embedded resources as String;
     * @param resourceName Name of the resource
     * @return The content as UTF-8 String
     */
    private String readResourceContent(String resourceName) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream(resourceName);

        try {
            byte[] content = new byte[resourceAsStream.available()];
            resourceAsStream.read(content);
            resourceAsStream.close();

            return new String(content, "UTF-8");
        } catch (IOException ioe) {
            return null;
        }
    }

    /**
     * Get region internal resources based on filter list.
     * Updates also the internal available list of regions
     * @param regions The filter. If null or empty, all available resources are returned
     * @return Array of filteredResources
     */
    private String[] getRegionResources(List<String> regions)  {
        String regionDescriptions = this.readResourceContent(REGIONS_PATH);
        String[] regionResources = regionDescriptions.split(",");

        List<String> filteredResources = new ArrayList<String>();
        for (String regionResource : regionResources) {
            String regionName = regionResource.split("/")[1];
            regionName = regionName.split("\\.")[0];

            if (regions == null || regions.isEmpty() || regions.contains(regionName)) {
                filteredResources.add(regionResource);
                availableRegions.add(regionName);
            }
        }
        return filteredResources.toArray(new String[filteredResources.size()]);
    }

    /**
     * Return the available regions
     * @return Unmodifiable list of available regions
     */
    public final List<String> availableRegions() {
        return Collections.unmodifiableList(this.availableRegions);
    }

    /**
     * Standard constructor with all available regions initialized
     * @throws IOException
     */
    public Holidays() {
        this(null);
    }

    /**
     * Constructors with filtered regions. Only the matching regions will be loaded.
     * @param regions The list of regions names
     */
    public Holidays(List<String> regions) {

        jrubyContainer.runScriptlet(this.getClass().getResourceAsStream(SCRIPTING_PATH), SCRIPTING_PATH);

        String[] regionsResourceNames = this.getRegionResources(regions);
        String rootPath = this.getClass().getPackage().getName().replace('.','/');

        for (String regionResourceName : regionsResourceNames) {
            String completePath = "/" + rootPath + "/" + regionResourceName;
            jrubyContainer.runScriptlet(this.getClass().getResourceAsStream(regionResourceName), completePath);
        }
    }

    /**
     * Returns all holidays between two dates for a list of defined regions. Options define if the results should include
     * informal and observed holidays
     * @param startDate The start date of the period in which holidays should be looked up
     * @param endDate The end date of the period in which holidays should be looked up
     * @param regions The regions for which holidays should be returned
     * @param options Can be any combination of informal and observed. eg Holidays.INFORMAL + Holidays.OBSERVED or Holidays.INFORMAL, or Holidays.NO_OPTION
     * @return The unmodifiable list of holidays
     * @throws HolidayException When anything goes bad
     */
    public List<Holiday> between(Date startDate, Date endDate, List<String> regions, byte options) throws HolidayException, UnknownRegionException {

        // Build up the jruby region symbol array
        RubySymbol[] regionsSymbols = new RubySymbol[regions.size()];
        int index = 0;
        for (String region : regions) {
            RubySymbol symbol = this.jrubyContainer.getProvider().getRuntime().getSymbolTable().getSymbol(region);
            regionsSymbols[index++] = symbol;
        }

        // Initialize the result list
        List<Holiday> holidays = new ArrayList<Holiday>();


        // Define period jruby start and end dates
        DateMidnight startDM = new DateMidnight(startDate);
        DateMidnight endDM = new DateMidnight(endDate);

        Object dateClass = this.jrubyContainer.get("Date");
        Object start = this.jrubyContainer.callMethod(dateClass, "civil", startDM.getYear(), startDM.getMonthOfYear(), startDM.getDayOfMonth());
        Object end = this.jrubyContainer.callMethod(dateClass, "civil", endDM.getYear(), endDM.getMonthOfYear(), endDM.getDayOfMonth());

        // Get the module
        Object holidayModule = this.jrubyContainer.get("Holidays");

        // Get informal and observed symbols
        RubySymbol observedSymbol = this.jrubyContainer.getProvider().getRuntime().getSymbolTable().getSymbol("observed");
        RubySymbol informalSymbol = this.jrubyContainer.getProvider().getRuntime().getSymbolTable().getSymbol("informal");

        try {

            // Call the actual Holidays JRuby method
            Object result;

            if (options == INFORMAL) {
                result = this.jrubyContainer.callMethod(holidayModule, "between", start, end, regionsSymbols, informalSymbol);
            } else if (options == OBSERVED) {
                result = this.jrubyContainer.callMethod(holidayModule, "between", start, end, regionsSymbols, observedSymbol);
            } else if (options == INFORMAL + OBSERVED) {
                result = this.jrubyContainer.callMethod(holidayModule, "between", start, end, regionsSymbols, observedSymbol, informalSymbol);
            } else {
                result = this.jrubyContainer.callMethod(holidayModule, "between", start, end, regionsSymbols);
            }

            // Check that we receive an actual array
            if (!(result instanceof RubyArray)) {
                throw new HolidayException("Result is not an array");
            }

            RubyArray array = (RubyArray) result;
            // Loop through the array elements and convert to Holiday bean
            for (Object o : array) {

                // Each object in the result array should be a hash of symbol/value pairs
                if (!(o instanceof RubyHash)) {
                    throw new HolidayException("Result element is not an hash object");
                }
                RubyHash hash = (RubyHash) o;


                String name = null;
                Date date = null;
                String[] holidayRegions = null;

                // Extract the values and convert them to Java
                for (Object key: hash.keySet()) {
                    String sym = ((RubySymbol) key).asJavaString();
                    if ("name".equals(sym)) {
                        name = (String) hash.get(key);
                    } else if ("date".equals(sym)) {
                        String dateText = hash.get(key).toString();
                        date = rubyDateFormat.parse(dateText);
                    } else if ("regions".equals(sym)) {
                        holidayRegions = (String[]) ((RubyArray) hash.get(key)).toArray(new String[((RubyArray) hash.get(key)).size()]);
                    }
                }

                holidays.add(new Holiday(date, name, holidayRegions));
            }

            return Collections.unmodifiableList(holidays);
        } catch (Exception e) {
            if (e instanceof InvokeFailedException && e.getMessage().contains("Holidays::UnknownRegionError")) {
                throw new UnknownRegionException();
            }
            throw new HolidayException(e);
        }
    }

    /**
     * Returns the list of holidays on a given date based on options and the regions provided.
     * @param date The date for which look for holidays
     * @param regions Regions to look for holidays
     * @param options Informal and observed
     * @return The unmodifiable list of holidays
     * @throws HolidayException When anything goes bad
     */
    public List<Holiday> on(Date date, List<String> regions, byte options) throws HolidayException, UnknownRegionException {
        return this.between(date, date, regions, options);
    }

    /**
     * Informs if a week is fully open or includes holidays
     * @param date One date in the week
     * @param regions Regions to look for the holidays
     * @param options Informal and observed
     * @param locale Locale of the date. This is used to determine first day of the week (Sunday,Monday, etc...)
     * @param includeWeekend If the fullweek should consider 7 days ot only start day + 5 open days
     * @return True if the week has no holidays in it, otherwise false
     * @throws HolidayException When anything goes bad
     */
    public boolean isFullWeek(Date date, List<String> regions, byte options, Locale locale, boolean includeWeekend) throws HolidayException, UnknownRegionException {

        int firstDayOfWeek = ((Calendar.getInstance(locale).getFirstDayOfWeek() + 5) % 7) + 1;

        DateMidnight dm = new DateMidnight(date);
        int dayInWeek = dm.getDayOfWeek();

        int daysToStart = dayInWeek - firstDayOfWeek;
        if (daysToStart < 0) {
            daysToStart = 7 + daysToStart;
        }

        DateMidnight start = dm.minusDays(daysToStart);
        DateMidnight end;
        if (includeWeekend) {
            end = start.plusWeeks(1);
        } else {
            end = start.plusDays(5);
        }

        return this.between(start.toDate(), end.toDate(), regions, options).isEmpty();
    }

    /**
     * Informs if a week is fully open or includes holidays for the default locale
     * @param date One date in the week
     * @param regions Regions to look for the holidays
     * @param options Informal and observed
     * @param includeWeekend If the fullweek should consider 7 days ot only start day + 5 open days
     * @return True if the week has no holidays in it, otherwise false
     * @throws HolidayException
     * @throws UnknownRegionException
     */
    public final boolean isFullWeek(Date date, List<String> regions, byte options, boolean includeWeekend) throws HolidayException, UnknownRegionException {
        return this.isFullWeek(date, regions,options, Locale.getDefault(), includeWeekend);
    }

    /**
     * Informs if a week is fully open or includes holidays for the default locale and 5 open days
     * @param date One date in the week
     * @param regions Regions to look for the holidays
     * @param options Informal and observed
     * @return True if the week has no holidays in it, otherwise false
     * @throws HolidayException
     * @throws UnknownRegionException
     */
    public final boolean isFullWeek(Date date, List<String> regions, byte options) throws HolidayException, UnknownRegionException {
        return this.isFullWeek(date, regions,options, Locale.getDefault(), false);
    }
}
