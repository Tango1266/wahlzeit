/*
 *  Copyright
 *
 *  Classname: Pattern
 *  Author: Tango1266
 *  Version: 24.01.18 19:51
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

package org.wahlzeit.utils.annotations.pattern;

import org.wahlzeit.utils.annotations.collaboration.Collaboration;

public abstract class Pattern implements Collaboration {
    public static String[] roles;
    public static String description;

    public String Client = "Client";

    @Override
    public String getPurpose() {
        return description;
    }
}
