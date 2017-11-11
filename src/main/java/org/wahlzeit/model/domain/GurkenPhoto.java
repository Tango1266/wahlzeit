/*
 *  Copyright
 *
 *  Classname: GurkenPhoto
 *  Author: Tango1266
 *  Version: 08.11.17 23:00
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

package org.wahlzeit.model.domain;

import com.googlecode.objectify.annotation.Subclass;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;
import org.wahlzeit.model.Location;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import javax.annotation.RegEx;
import java.util.regex.Pattern;

/**
 * A gurkenphoto represents a user-provided (uploaded) photo of a cucumber.
 */

@Subclass
public class GurkenPhoto extends Photo {

    private Taste taste;
    private int size;
    private String type;

    public GurkenPhoto() {
    }

    public GurkenPhoto(PhotoId myId) {
        super(myId);
    }

    public GurkenPhoto(String type, int sizeInMillimeter, Taste taste, Location location) {
        this.type=type;
        this.size=sizeInMillimeter;
        this.taste=taste;
        this.location=location;
    }

    public void setType(String type) {
        assertStartsWithLiterals(type);
        this.type = type;
    }

    private void assertStartsWithLiterals(String type) {
        if(Pattern.matches("^(\\d.*)",type))
            throw new IllegalArgumentException("Type should start with literals but is actually"+type);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public Taste getTaste() {
        return taste;
    }
}
