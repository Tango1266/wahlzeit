/*
 *  Copyright
 *
 *  Classname: GurkenPhotoManager
 *  Author: Tango1266
 *  Version: 08.11.17 22:47
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

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;

import java.util.logging.Logger;

/**
 * A photo manager provides access to and manages photos.
 */
public class GurkenPhotoManager extends PhotoManager {

    private static final Logger log = Logger.getLogger(GurkenPhotoManager.class.getName());
    /**
     *
     */
    protected static final GurkenPhotoManager instance = new GurkenPhotoManager();

    /**
     *
     */
    public GurkenPhotoManager() {
        photoTagCollector = GurkenPhotoFactory.getInstance().createPhotoTagCollector();
    }

    @Override
    protected Logger getLogger() {
        return log;
    }

    /**
     *
     */
    @Override
    public final Photo getPhoto(PhotoId id) {
        return getInstance().getPhotoFromId(id);
    }

    /**
     *
     */
    @Override
    public Photo getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        Photo result = doGetPhotoFromId(id);

        if (result == null) {
            result = GurkenPhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;
    }

    /**
     *
     */
    public static final GurkenPhotoManager getInstance() {
        return instance;
    }
}
