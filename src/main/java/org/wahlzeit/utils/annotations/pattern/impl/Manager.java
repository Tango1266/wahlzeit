/*
 *  Copyright
 *
 *  Classname: Manager
 *  Author: Tango1266
 *  Version: 24.01.18 22:53
 *
 *  This file is part of the Wahlzeit photo rating application.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public
 *  License along with this program. If not, see
 *  <http://www.gnu.org/licenses/>
 */

package org.wahlzeit.utils.annotations.pattern.impl;

import org.wahlzeit.utils.annotations.pattern.Pattern;

public class Manager extends Pattern {
    public static final String Manager = "Manager";
    public static final String Element = "Element";

    public Manager() {
        description = "\"Centralize object management in one place.(ADAP, 2017)\"";
        roles = new String[]{"Abstract BaseObject, Null BaseObject"};
    }

}
