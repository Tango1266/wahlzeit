/*
 *  Copyright
 *
 *  Classname: Gurke
 *  Author: Tango1266
 *  Version: 14.01.18 11:45
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

@PatternInstance(
        pattern = Pattern.TypeObject.class,
        classRole = "Object",
        participants = {Gurke.class, GurkenType.class}
)
/**
 * Represents a specific Gurke of a certain GurkenType
 *
 * ===== Sequence of method calls =========
 * 0) GurkenManager calls PhotoUtil#createPhoto
 * 1) PhotoUtil calls GurkenPhotoFactory#createPhoto
 * 2) GurkenPhotoFactory calls GurkenManager#getGurke with a fully specified signature to get a Gurke
 * 2) GurkenManager creates eventually a GurkenType if it is not known yet otherwise it will get it from a cache
 * 4) GurkenManager calls GurkenType#createInstance to create a Gurke.
 *
 * ===== Six tuple - Solution space =========
 * Delegation:	    Separate-object     ->	GurkenManager
 * Selection:	    By-subclassing	    -> Sublass of PhotoFactory determines the Selection
 * Configuration:	-
 * Instantiation:	In-code	            -> No configuration needed
 * Initialization:	In-second-step      -> type-hierarchy can be too complex, client must determine super and subtypes at any time
 * Building:        Default
 */
public class Gurke extends DataObject{
    private Taste taste;
    private int size;
    /* Metainformation provided from type, so
    *  objectify does not need to pull attributes from type
    */
    private String strain;

    @Ignore /*required public attribute by uml spec*/
    public GurkenManager manager = GurkenManager.getInstance();
    @Ignore /*required public attribute by uml spec*/
    public GurkenType type;

    public Gurke(GurkenType type, Taste taste, int size) {
        setType(type);
        setTaste(taste);
        setSize(size);
        setStrain(type.getStrain());
    }

    public Gurke(GurkenType type) {
        setType(type);
        setStrain(type.getStrain());
    }

    public void setType(GurkenType type) {
        Assert.notNull(type, "GurkenType");
        this.type = type;
    }

    public GurkenType getType() {
        return type;
    }

    public void setSize(int size) {
        Assert.areValidDoubles(size);
        this.size = size;
    }

    public void setTaste(Taste taste) {
        Assert.notNull(taste, "Taste");
        this.taste = taste;
    }

    public int getSize() {
        return size;
    }

    public Taste getTaste() {
        return taste;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
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

        Gurke gurke = (Gurke) o;

        if (getSize() != gurke.getSize()) {
            return false;
        }
        if (getTaste() != gurke.getTaste()) {
            return false;
        }
        if (getStrain() != null ? !getStrain().equals(gurke.getStrain()) : gurke.getStrain() != null) {
            return false;
        }
        return getType() != null ? getType().equals(gurke.getType()) : gurke.getType() == null;
    }

    @Override
    public String toString() {
        return "Gurke{" +
                "taste=" + taste +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
