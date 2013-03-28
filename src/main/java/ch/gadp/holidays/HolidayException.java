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

/**
 * General Exception wrapping ruby gem exceptions
 */
public class HolidayException extends Exception {
    /**
     * Default constructor with Throwable
     * @param e Throwable
     */
    public HolidayException(Throwable e) {
        super(e);
    }

    /**
     * Default constructor with some human readable message
     * @param str Message
     */

    public HolidayException(String str) {
        super(str);
    }

}
