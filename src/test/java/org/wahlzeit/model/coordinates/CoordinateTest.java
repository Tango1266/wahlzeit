/*
 *  Copyright
 *
 *  Classname: CoordinateTest
 *  Author: Tango1266
 *  Version: 16.11.17 16:10
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

package org.wahlzeit.model.coordinates;

import org.junit.Assert;

public class CoordinateTest {
    protected static final Double VALUE_EXCEEDING_COORD_MAXVALUE = Double.MAX_VALUE - 1E291;

    protected static void CheckDistance(Coordinate first, Coordinate second, double expectedDistance, double tolerance) {
        double distance = first.getDistance(second);
        Assert.assertEquals(expectedDistance, distance, tolerance);
    }
}
