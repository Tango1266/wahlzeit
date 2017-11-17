/*
 *  Copyright
 *
 *  Classname: Assert
 *  Author: Tango1266
 *  Version: 17.11.17 14:21
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

import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

public class Assert {
    /**
     * checks whether a value is lesser then zero
     * @methodtype assert
     */
    public static void notNegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("The radius must be greater then 0 but was actually " + value);
        }
    }

    /**
     * checks whether a value is lesser then |maxValue|
     * @methodtype assert
     */
    public static void inRangeMax(double value, double maxValue) {
        inRangeMax(value, maxValue, "");
    }

    public static void inRangeMax(double value, double maxValue, String valueSpecification) {
        if (maxValue - Math.abs(value) < -SphericCoordinate.PRECISION) {
            String errorMessage = "";
            if (valueSpecification.length() > 0) {
                errorMessage = String.format(valueSpecification + " exceeded the defined range. ");
            }
            errorMessage = String.format(errorMessage + "The value was \"" + value + "\" but must be in the range of [-" + maxValue + ":" + maxValue + "]");
            throw new IllegalArgumentException(errorMessage);
        }
    }
}