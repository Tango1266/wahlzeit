/*
 *  Copyright
 *
 *  Classname: AbstractFactory
 *  Author: Tango1266
 *  Version: 24.01.18 20:43
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

public class AbstractFactory extends Pattern {
    public static final String AbstractFactory = "AbstractFactory";
    public static final String ConcreteFactory = "ConcreteFactory";

    public AbstractFactory() {
        description = "\"The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes\" (wikipedia.org, 2018)";
        roles = new String[]{"Abstract Factory, Concrete Factory"};
    }
}
