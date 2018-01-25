/*
 *  Copyright
 *
 *  Classname: GurkenManager
 *  Author: Tango1266
 *  Version: 14.01.18 11:19
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

package org.wahlzeit.model.gurkenDomain;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.utils.Assert;
import org.wahlzeit.utils.annotations.Collaboration;
import org.wahlzeit.utils.annotations.Role;
import org.wahlzeit.utils.annotations.pattern.impl.Manager;

import java.util.concurrent.ConcurrentHashMap;

@Collaboration(
        type = Manager.class,
        role = Manager.Manager,
        instances = {
                GurkenManager.class, GurkenType.class, Gurke.class
        }
)
/**
 * Manages the domain subject Service and its corresponding Types.
 * Should be understood as a single touch point to interact with the domain subject.
 */
public class GurkenManager extends ObjectManager{

    private static final GurkenManager instance = new GurkenManager();
    /*Threadsafe implementations of HashMap*/
    private ConcurrentHashMap<String, GurkenType> types = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Gurke> gurken = new ConcurrentHashMap<>();

    protected GurkenType gurkenType;

    public GurkenManager() {
        gurkenType = new GurkenType();
    }

    public static GurkenManager getInstance() {
        return instance;
    }

    /**
     * implementation of the value object pattern. It gets the desired object from a cache.
     * It will create and eventually cache the desired object and corresponding {@link GurkenType}
     * in {@link GurkenManager#getType(String)}.
     * @methodtype query-, mutation-, factory method
     */
    @Role({Manager.Manager})
    public Gurke getGurke(String type, Taste taste, int size) {
        GurkenType gt = getType(type);
        Gurke gurke = gt.createInstance(taste, size);
        int mapKey = gurke.hashCode();
        if (!gurken.containsKey(mapKey)) {
            gurken.put(mapKey, gurke);
            return gurke;
        }
        return gurken.get(mapKey);
    }

    /**
     * {@link GurkenManager#getGurke(String, Taste, int)}
     */
    @Role({Manager.Manager})
    public Gurke getGurke(String type) {
        return getGurke(type, Taste.UNSPECIFIED, 0);
    }

    /**
     * implementation of the value object pattern. It gets the desired object from a cache.
     * Eventually, it will create and cache the desired object.
     * @methodtype query-, mutation-, factory method
     */
    @Role({Manager.Manager})
    public GurkenType getType(String gurkenTypeName) {
        assertIsValidTypeName(gurkenTypeName);
        if (!types.containsKey(gurkenTypeName)) {
            return createType(gurkenTypeName);
        }
        return types.get(gurkenTypeName);
    }

    private void assertIsValidTypeName(String gurkenTypeName) {
        Assert.notNull(gurkenTypeName, "GurkenType Name");
        Assert.stringNotEmpty(gurkenTypeName);
    }

    @Role({Manager.Manager})
    private GurkenType createType(String gurkenType) {
        GurkenType newGurkenType = new GurkenType(gurkenType);
        types.put(gurkenType, newGurkenType);
        return newGurkenType;
    }
}
