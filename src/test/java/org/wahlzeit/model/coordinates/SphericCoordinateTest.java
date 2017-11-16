/*
 *  Copyright
 *
 *  Classname: SphericCoordinateTest
 *  Author: Tango1266
 *  Version: 16.11.17 16:05
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
import org.junit.Test;
import org.wahlzeit.model.coordinates.impl.SphericCoordinate;

public class SphericCoordinateTest extends CoordinateTest {

    @Test
    public void createSpericCoordinate_notNull() {
        Assert.assertNotNull(new SphericCoordinate());
    }

    @Test
    public void getLongitude_afterSettingItToValue_returnsValue() {
        SphericCoordinate sphCord = new SphericCoordinate();
        double value = 2.22;
        sphCord.setLongitude(value);
        Assert.assertEquals(value, sphCord.getLongitude(), 0);
    }

    @Test
    public void getRadius_afterSettingItToValue_returnsValue() {
        SphericCoordinate sphCord = new SphericCoordinate();
        double value = 2.22;
        sphCord.setRadius(value);
        Assert.assertEquals(value, sphCord.getRadius(), 0);
    }

    @Test
    public void sphericCoord_isSubclassOfCoordinate_isTrue() {
        Assert.assertTrue(Coordinate.class.isAssignableFrom(SphericCoordinate.class));
    }

    @Test
    public void sphericCoord_isSuperclassOfCoordinate_isFalse() {
        Assert.assertFalse(SphericCoordinate.class.isAssignableFrom(Coordinate.class));
    }

}
