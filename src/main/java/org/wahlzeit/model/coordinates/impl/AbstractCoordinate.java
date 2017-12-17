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
import org.wahlzeit.utils.Assert;
import org.wahlzeit.utils.MathUtils;

import java.util.HashMap;

public abstract class AbstractCoordinate implements Coordinate {
    protected final static HashMap<Integer, Coordinate> coordinateCache = new HashMap<>();

    public static void saveCoordinate(Coordinate coordinate) {
        if (!isExistingCoordinate(coordinate)) {
            coordinateCache.put(coordinate.hashCode(), coordinate);
        }
    }

    public static boolean isExistingCoordinate(Coordinate coordinate) {
        return coordinateCache.containsKey(coordinate.hashCode());
    }

    public static Coordinate getCoordinateFromCache(Coordinate coordinate) {
        saveCoordinate(coordinate);
        return coordinateCache.get(coordinate.hashCode());
    }

    public static boolean isNoWhere(Coordinate otherCoord) {
        Assert.notNull(otherCoord, "");
        return otherCoord instanceof NoWhereCoordinate;
    }

    /**
     * @return distance, defined by its caller
     */
    protected abstract double doCalculateDistance(Coordinate otherCoord);

    protected abstract void assertClassInvariants();

    @Override
    public double getDistance(Coordinate otherCoord) {
        return getCartesianDistance(otherCoord);
    }

    @Override
    public double getCartesianDistance(Coordinate otherCoord) {
        if (isNoWhere(otherCoord)) {
            return -1;
        }
        return asCartesianCoordinate().doCalculateDistance(otherCoord);
    }

    @Override
    public double getSphericDistance(Coordinate otherCoord) {
        if (isNoWhere(otherCoord)) {
            return -1;
        }
        return asSphericCoordinate().doCalculateDistance(otherCoord);
    }

    @Override
    public boolean isEqual(Coordinate otherCoord) {
        if (this == otherCoord) {
            return true;
        }
        if (isNoWhere(otherCoord)) {
            return false;
        }
        return getDistance(otherCoord) <= MathUtils.getPrecision();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * @see {@link #isEqual(Coordinate) isEqual(Coordinate)}
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Coordinate && isEqual((Coordinate) o);
    }
}
