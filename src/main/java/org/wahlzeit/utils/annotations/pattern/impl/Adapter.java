/*
 *  Copyright
 *
 *  Classname: Adapter
 *  Author: Tango1266
 *  Version: 24.01.18 20:44
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

public class Adapter extends Pattern {
    public static final String Adapter = "Adapter";
    public static final String ConcreteAdapter = "ConcreteAdapter";
    public static final String Adaptee = "Adaptee";

    public Adapter() {
        description = "\"Adapter allows the interface of an existing class to be used as another interface.[1] It is often used to make existing classes work with others without modifying their source code.\" (wikipedia.org, 2018";
        roles = new String[]{"Adapter", "Concrete Adapter", "Adaptee"};
    }
}
