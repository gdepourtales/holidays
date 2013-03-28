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

import junit.framework.Assert;
import org.apache.commons.lang.ArrayUtils;
import org.joda.time.DateMidnight;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guy
 * Date: 3/22/13
 * Time: 3:08 PM
 */
public class DateTestingHelper {

    private static Holidays HOLIDAYS = null;

    private static Holidays getHolidaysInstance() {
        if (HOLIDAYS == null) {
            HOLIDAYS = new Holidays();
        }

        return HOLIDAYS;
    }

    public static void testSingleRegionSingleDayHoliday(String region, DateMidnight date, String name) throws HolidayException, UnknownRegionException {
        testSingleRegionSingleDayHoliday(getHolidaysInstance(), region, date, name, (byte) 0x00, 1);
    }

    public static void testSingleRegionSingleDayHoliday(Holidays holidays, String region, DateMidnight date, String name) throws HolidayException, UnknownRegionException {
        testSingleRegionSingleDayHoliday(holidays, region, date, name, (byte) 0x00, 1);
    }

    public static void testSingleRegionSingleDayHoliday(String region, DateMidnight date, String name, byte options) throws HolidayException, UnknownRegionException {
        testSingleRegionSingleDayHoliday(getHolidaysInstance(), region, date, name, options, 1);
    }

    public static void testSingleRegionSingleDayHoliday(Holidays holidays, String region, DateMidnight date, String name, byte options) throws HolidayException, UnknownRegionException {
        testSingleRegionSingleDayHoliday(holidays, region, date, name, options, 1);
    }

    public static void testSingleRegionSingleDayHoliday(String region, DateMidnight date, String name, byte options, int resultsSize) throws HolidayException, UnknownRegionException {
        testSingleRegionSingleDayHoliday(getHolidaysInstance(), region, date, name, options, resultsSize);
    }

    public static void testSingleRegionSingleDayHoliday(Holidays holidays, String region, DateMidnight date, String name, byte options, int resultsSize) throws HolidayException, UnknownRegionException {
        List<Holiday> results = holidays.between(
                date.toDate(),
                date.toDate(),
                Arrays.asList(region), options);

        Assert.assertNotNull(results);
        Assert.assertEquals(resultsSize, results.size());


        Holiday holiday = null;
        for (Holiday h : results) {
            if (name.equals(h.getName())) {
                holiday = h;
                break;
            }

        }
        Assert.assertNotNull("At least one holiday named '" + name + "'", holiday);

        Assert.assertEquals(name, holiday.getName());
        Assert.assertEquals(date.toDate(), holiday.getDate());
        Assert.assertTrue(holiday.getRegions().length != 0);
        String mainRegion = region.split("_")[0];
        Assert.assertTrue(ArrayUtils.contains(holiday.getRegions(), region) || ArrayUtils.contains(holiday.getRegions(), mainRegion));
    }

    public static void testMultipleRegionsSingleDayHoliday(String[] regions, DateMidnight date, String name) throws Exception {
        testMultipleRegionsSingleDayHoliday(regions, date, name, 1);
    }

    public static void testMultipleRegionsSingleDayHoliday(String[] regions, DateMidnight date, String name, int resultsSize) throws Exception {
        Holidays holidays = getHolidaysInstance();
        List<Holiday> results = holidays.between(
                date.toDate(),
                date.toDate(),
                Arrays.asList(regions), Holidays.NO_OPTION);

        Assert.assertNotNull(results);
        Assert.assertEquals(resultsSize, results.size());


        Holiday holiday = null;
        for (Holiday h : results) {
            if (name.equals(h.getName())) {
                holiday = h;
                break;
            }

        }
        Assert.assertNotNull(holiday);

        Assert.assertEquals(name, holiday.getName());
        Assert.assertEquals(date.toDate(), holiday.getDate());
        Assert.assertTrue(ArrayUtils.isNotEmpty(holiday.getRegions()));

        for (String region : regions) {
            if (!region.endsWith("_")) {
                Assert.assertTrue("Region '" + region + "' not found", ArrayUtils.contains(holiday.getRegions(), region));
            }
        }
    }

    public static void testSingleRegionSingleDayNotHoliday(String region, DateMidnight date) throws Exception {
        Holidays holidays = getHolidaysInstance();
        List<Holiday> results = holidays.between(
                date.toDate(),
                date.toDate(),
                Arrays.asList(region), Holidays.NO_OPTION);

        Assert.assertNotNull(results);
        Assert.assertTrue(results.isEmpty());
    }

    public static void testSingleRegionSingleDayNotHoliday(Holidays holidays, String region, DateMidnight date) throws Exception {
        List<Holiday> results = holidays.between(
                date.toDate(),
                date.toDate(),
                Arrays.asList(region), Holidays.NO_OPTION);

        Assert.assertNotNull(results);
        Assert.assertTrue(results.isEmpty());
    }

}
