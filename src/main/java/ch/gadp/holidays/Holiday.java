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

import java.util.Date;

/**
 * Simple Java POJO holding Holiday information
 */
public final class Holiday {
    /**
     * The name of the holiday
     */
    private String name;

    /**
     * The date of the holiday in default Locale
     */
    private Date date;

    /**
     * The regions in which the holiday is available
     */
    private String[] regions;

    /**
     * Protected constructor to build a new Holiday POJO
     * @param date The date
     * @param name The name
     * @param regions The regions
     */
    protected Holiday(Date date, String name, String[] regions) {
        this.date = date;
        this.name = name;
        this.regions = regions;
    }

    /**
     * The date of the holiday in default Locale
     * @return The Holiday effective date
     */
    public Date getDate() {
        return date;
    }

    /**
     * The name of the holiday
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * All regions where the holiday is applied
     * @return The holiday regions array
     */
    public String[] getRegions() {
        return regions;
    }
}
