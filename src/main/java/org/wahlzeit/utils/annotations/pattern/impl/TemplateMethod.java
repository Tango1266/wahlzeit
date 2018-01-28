/*
 *  Copyright
 *
 *  Classname: TemplateMethod
 *  Author: Tango1266
 *  Version: 24.01.18 20:00
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

public class TemplateMethod extends Pattern {
    public static final String AbstractClass = "AbstractClass";
    public static final String ConcreteClass = "ConcreteClass";

    public TemplateMethod() {
        description = "\"defines the program skeleton of an algorithm in an operation, deferring some steps to subclasses.[\" (wikipedia.org, 2018)";
        roles = new String[]{"Abstract Class", "Concrete Class"};
    }

}
