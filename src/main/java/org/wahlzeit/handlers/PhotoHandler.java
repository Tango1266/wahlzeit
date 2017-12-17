/*
 *  Copyright
 *
 *  Classname: ErrorHandler
 *  Author: Tango1266
 *  Version: 17.12.17 09:37
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

package org.wahlzeit.handlers;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.model.exceptions.PhotoCouldNotBeFetchedException;

public class PhotoHandler {
    /**
     * @return desired {@link Photo} determined by provided id. In case of any error, a new empty instance of {@link Photo}
     */
    public static Photo getPhotoIgnoreException(String id) {
        return getPhotoIgnoreException(id, new Photo());
    }

    /**
     * @return desired photo determined by provided id. In case any error, the provided defaultValue
     */
    public static Photo getPhotoIgnoreException(String id, Photo defaultValue) {
        Photo photo = defaultValue;
        try {
            photo = PhotoManager.getInstance().getPhoto(id);
        } catch (PhotoCouldNotBeFetchedException e) {
            //photo retrieval failed
        }
        return photo;
    }
}
