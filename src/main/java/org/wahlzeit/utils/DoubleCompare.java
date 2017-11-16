/*
 *  Copyright
 *
 *  Classname: DoubleUtils
 *  Author: Tango1266
 *  Version: 16.11.17 23:37
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

package org.wahlzeit.utils;

import com.google.common.math.DoubleMath;

public class DoubleCompare {
    private static final double DEFAULT_DELTA = 1.0E-8;
    private static double delta = DEFAULT_DELTA;

    public DoubleCompare() {
    }

    public DoubleCompare(double delta) {
        delta = DEFAULT_DELTA;
    }

    /**
     * if not other defined it will compare two doubles with a default precision of 1.0E-10
     */
    public static boolean areEqual(double valuaA, double valueB) {
        return DoubleMath.fuzzyEquals(valuaA, valueB, delta);
    }

    public static boolean areNotEqual(double valuaA, double valueB) {
        return !areEqual(valuaA, valueB);
    }

    public static double getDelta() {
        return delta;
    }

    public static void setDelta(double desiredDelta) {
        delta = desiredDelta;
    }
}
