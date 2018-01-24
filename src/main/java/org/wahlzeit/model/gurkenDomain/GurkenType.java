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
import org.wahlzeit.utils.annotations.Collaboration;
import org.wahlzeit.utils.annotations.PatternInstance;
import org.wahlzeit.utils.annotations.Role;
import org.wahlzeit.utils.annotations.pattern.impl.TypeObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@PatternInstance(
        pattern = TypeObject.class,
        classRole = TypeObject.TypeObject,
        participants = {Gurke.class, GurkenType.class}
)
@Collaboration(
        type = {TypeObject.class},
        role = TypeObject.TypeObject,
        instances = {Gurke.class, GurkenType.class}
)
/**
 * Represents a certain GurkenType with its meta information.
 * GurkenTypes will be determined during runtime
 */
public class GurkenType extends DataObject {
    private String strain;
    @Ignore
    GurkenManager manager;
    @Ignore
    public GurkenType superType = null;
    @Ignore
    public Set<GurkenType> subTypes = new HashSet<>();

    @Role(TypeObject.TypeObject)
    public GurkenType(String strain) {
        setStrain(strain);
    }

    public GurkenType() {
        manager = GurkenManager.getInstance();
    }

    @Role(TypeObject.TypeObject)
    public boolean hasInstance(Gurke gurke) {
        Assert.notNull(gurke, "Gurken Instance");
        return isSubType(gurke.getType());
    }

    @Role(TypeObject.TypeObject)
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

    @Role(TypeObject.TypeObject)
    public GurkenType getSuperType() {
        return superType;
    }

    @Role(TypeObject.TypeObject)
    public void setSuperType(GurkenType superType) {
        this.superType = superType;
    }

    @Role(TypeObject.TypeObject)
    public Iterator<GurkenType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * @methodtype mutation method
     */
    @Role(TypeObject.TypeObject)
    public void addSubType(GurkenType gurkenType) {
        Assert.notNull(gurkenType, "GurkenSubType");
        gurkenType.setSuperType(this);
        subTypes.add(gurkenType);
    }

    @Role(TypeObject.TypeObject)
    public String getStrain() {
        return strain;
    }

    @Role(TypeObject.TypeObject)
    public void setStrain(String strain) {
        Assert.stringStartsWithLiterals(strain, "cucumber-type");
        this.strain = strain;
    }

    /**
     * @methodtype factory method
     */
    @Role(TypeObject.TypeObject)
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
