/*
 *  Copyright
 *
 *  Classname: AbstractCoordinate
 *  Author: Tango1266
 *  Version: 22.11.17 17:39
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

package org.wahlzeit.model.coordinates.impl;

import org.wahlzeit.model.coordinates.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

    /**
     * @return distance, defined by its caller
     */
    protected abstract double doCalculateDistance(Coordinate otherCoord);

    /**
     * @return true, if the properties defined by its caller are equal
     */
    protected abstract boolean doIsEqual(Coordinate otherCoord);

    /**
     * @return -1, if otherCood is null or NoWhereCoordinate. The direct distance, otherwise.
     */
    @Override
    public double getDistance(Coordinate otherCoord) {
        return getCartesianDistance(otherCoord);
    }

    @Override
    public double getCartesianDistance(Coordinate otherCoord) {
        if (isNullOrNullCoordinate(otherCoord)) {
            return -1;
        }
        return asCartesianCoordinate().doCalculateDistance(otherCoord);
    }

    @Override
    public double getSphericDistance(Coordinate otherCoord) {
        if (isNullOrNullCoordinate(otherCoord)) {
            return -1;
        }
        return asSphericCoordinate().doCalculateDistance(otherCoord);
    }

    @Override
    public boolean isEqual(Coordinate otherCoord) {
        if (this == otherCoord) {
            return true;
        }
        if (otherCoord == null) {
            return false;
        }
        return doIsEqual(otherCoord);
    }

    @Override
    public abstract int hashCode();

    /**
     * {@link #isEqual(Coordinate) isEqual(Coordinate)}
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Coordinate && isEqual((Coordinate) o);
    }

    private boolean isNullOrNullCoordinate(Coordinate otherCoord) {
        return otherCoord instanceof NoWhereCoordinate || otherCoord == null;
    }

}
