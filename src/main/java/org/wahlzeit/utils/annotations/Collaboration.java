/*
 *  Copyright
 *
 *  Classname: Collaboration
 *  Author: Tango1266
 *  Version: 24.01.18 21:38
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

package org.wahlzeit.utils.annotations;

/**
 * an effort implement Collaboration based design principles in form of annotations
 */
public @interface Collaboration {
    /**
     * "A model of objects collaborating for one particular purpose"(ADAP, 2017)
     */
    Class[] type();

    /**
     * "A model of the behavior of one object within a collaboration"(ADAP, 2017)
     */
    String[] role();

    /**
     * "A set of specific objects collaborating according to a collaboration specification"(ADAP, 2017)
     */
    Class[] instances();
}
