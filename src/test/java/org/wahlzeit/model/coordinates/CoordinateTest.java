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
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinates.impl.CartesianCoordinate;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

public class CoordinateTest {
    protected static final Double VALUE_EXCEEDING_COORD_MAXVALUE = Double.MAX_VALUE - 1E291;

    protected Coordinate berlinBarndBurgCartesian;
    protected Coordinate lissabonBrueckeCartesian;
    protected Coordinate berlinBarndBurgSpheric;
    protected Coordinate lissabonBrueckeSpheric;

    @Before
    public void setUpTest() {
        berlinBarndBurgCartesian = new CartesianCoordinate(897_997.802, 1_170_987.368, 6_204_939.366);
        lissabonBrueckeCartesian = new CartesianCoordinate(-794_012.0811, -635_956.8219, 6_296_347.174);

        berlinBarndBurgSpheric = new SphericCoordinate(52.5164, 13.3777);
        lissabonBrueckeSpheric = new SphericCoordinate(38.692668, -9.177944);
    }

    @Test
    public void convertingBerlinCartesian_toSphericAndBack_inIsEqualOut() {
        Coordinate convertedToSpherich = berlinBarndBurgCartesian.asSphericCoordinate();
        Coordinate convertedBackToCart = convertedToSpherich.asCartesianCoordinate();
        Assert.assertEquals(berlinBarndBurgCartesian, convertedBackToCart);
    }

    @Test
    public void convertingZeroSpheric_toCartesianAndBack_inIsEqualOut() {
        Coordinate spheric = new SphericCoordinate(0, 0);
        Assert.assertEquals(spheric, spheric.asCartesianCoordinate().asSphericCoordinate());
    }

    @Test
    public void convertingZeroCartesion_toSphericAndBack_inIsEqualOut() {
        Coordinate cartesian = new CartesianCoordinate(0, 0, 0);
        Assert.assertEquals(cartesian, cartesian.asSphericCoordinate().asCartesianCoordinate());
    }

    @Test
    public void creatingTwoCartesions_whereOneIsBuildFromSpheric_areEqual() {
        Coordinate spheric = new SphericCoordinate(10, 12);

        CartesianCoordinate convertedCartesian = spheric.asCartesianCoordinate();
        Coordinate cartesian = new CartesianCoordinate(convertedCartesian.getX(), convertedCartesian.getY(), convertedCartesian.getZ());

        Assert.assertEquals(spheric, (cartesian.asSphericCoordinate()));
    }

    protected static void checkDistance(Coordinate first, Coordinate second, double expectedDistance, double tolerance) {
        double distance = first.getDistance(second);
        Assert.assertEquals(expectedDistance, distance, tolerance);
    }
}
