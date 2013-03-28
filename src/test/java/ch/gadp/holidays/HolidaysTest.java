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
import junit.framework.TestCase;
import org.apache.commons.lang.ArrayUtils;
import org.joda.time.DateMidnight;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: guy
 * Date: 3/25/13
 * Time: 12:25 PM
 */
public class HolidaysTest extends TestCase {

    public void testConstructors() throws Exception {
        List<String> regions = Arrays.asList("unknown_region");
        Holidays holidays = new Holidays(regions);
        assertTrue(holidays.availableRegions().isEmpty());
        Exception e = null;
        try {
            DateTestingHelper.testSingleRegionSingleDayNotHoliday(holidays, "at", new DateMidnight(2009, 1, 1));
        } catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof UnknownRegionException);

        regions = Arrays.asList("at");
        holidays = new Holidays(regions);
        assertEquals(1, holidays.availableRegions().size());
        DateTestingHelper.testSingleRegionSingleDayHoliday(holidays, "at", new DateMidnight(2009, 1, 1), "Neujahrstag");

        e = null;
        try {
            DateTestingHelper.testSingleRegionSingleDayNotHoliday(holidays, "au", new DateMidnight(2009, 1, 1));
        } catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof UnknownRegionException);
    }

    public void testBetween() throws Exception {
        Holidays holidays = new Holidays();
        DateTestingHelper.testSingleRegionSingleDayHoliday(holidays, "at", new DateMidnight(2009, 1, 1), "Neujahrstag");

        DateMidnight start = new DateMidnight(2012, 1, 1);
        DateMidnight end = new DateMidnight(2012, 1, 5);

        List<Holiday> results = holidays.between(
                start.toDate(),
                end.toDate(),
                Arrays.asList("at"), Holidays.NO_OPTION);

        Assert.assertNotNull(results);
        Assert.assertEquals(1, results.size());

        start = new DateMidnight(2012, 12, 25);
        end = new DateMidnight(2012, 12, 28);

        results = holidays.between(
                start.toDate(),
                end.toDate(),
                Arrays.asList("at"), Holidays.NO_OPTION);

        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

    public void testIsFullWeek() throws HolidayException, UnknownRegionException {
        Holidays holidays = new Holidays();

        assertFalse(holidays.isFullWeek(new DateMidnight(2011, 12, 25).toDate(), Arrays.asList("at"), Holidays.NO_OPTION, Locale.FRANCE, true));
        assertTrue(holidays.isFullWeek(new DateMidnight(2011, 12, 25).toDate(), Arrays.asList("at"), Holidays.NO_OPTION, Locale.FRANCE, false));

        assertFalse(holidays.isFullWeek(new DateMidnight(2012, 12, 25).toDate(), Arrays.asList("at"), Holidays.NO_OPTION));


    }

}
