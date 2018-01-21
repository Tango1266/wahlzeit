/*
 *  Copyright
 *
 *  Classname: GurkenType
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

import com.googlecode.objectify.annotation.Ignore;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.Assert;
import org.wahlzeit.utils.Pattern;
import org.wahlzeit.utils.PatternInstance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@PatternInstance(
        pattern = Pattern.TypeObject.class,
        classRole = "Type Object",
        participants = {Gurke.class, GurkenType.class}
)
/**
 * Represents a certain GurkenType with its meta information.
 * GurkenTypes will be determined during runtime
 */
public class GurkenType extends DataObject {
    private String strain;
    @Ignore
    private Set<GurkenType> subTypes = Collections.synchronizedSet(new HashSet<GurkenType>());
    @Ignore
    private GurkenType superType = null;
    @Ignore
    public /*because of uml-req*/ GurkenManager manager;

    public GurkenType(String strain) {
        setStrain(strain);
    }

    public GurkenType() {
        manager = GurkenManager.getInstance();
    }

    public boolean hasInstance(Gurke gurke) {
        Assert.notNull(gurke, "Gurken Instance");
        return isSubType(gurke.getType());
    }

    public boolean isSubType(GurkenType gurkenType) {
        Assert.notNull(gurkenType, "Gurken Subtype");

        if (gurkenType == this) {
            return true;
        }
        Iterator<GurkenType> subTypeItter = getSubTypeIterator();
        while (subTypeItter.hasNext()) {
            GurkenType nextSubType = subTypeItter.next();
            if (nextSubType.isSubType(gurkenType)) {
                return true;
            }
        }
        return false;
    }

    public GurkenType getSuperType() {
        return superType;
    }

    public void setSuperType(GurkenType superType) {
        this.superType = superType;
    }

    public Iterator<GurkenType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * @methodtype mutation method
     */
    public void addSubType(GurkenType gurkenType) {
        Assert.notNull(gurkenType, "GurkenSubType");
        gurkenType.setSuperType(this);
        subTypes.add(gurkenType);
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        Assert.stringStartsWithLiterals(strain, "cucumber-type");
        this.strain = strain;
    }

    /**
     * @methodtype factory method
     */
    public Gurke createInstance(Taste taste, int size) {
        return new Gurke(this, taste, size);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GurkenType that = (GurkenType) o;

        if (!getStrain().equals(that.getStrain())) {
            return false;
        }
        if (getSuperType() != null ? !getSuperType().equals(that.getSuperType()) : that.getSuperType() != null) {
            return false;
        }
        return subTypes.equals(that.subTypes);
    }

    @Override
    public String toString() {
        return "GurkenType{" +
                ", strain='" + getStrain() + '\'' +
                '}';
    }

}
