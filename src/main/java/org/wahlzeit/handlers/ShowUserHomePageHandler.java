/*
 *  Copyright
 *
 *  Classname: ShowUserHomePageHandler
 *  Author: Tango1266
 *  Version: 08.11.17 22:26
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

import org.wahlzeit.model.*;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.HtmlUtil;
import org.wahlzeit.webparts.WebPart;
import org.wahlzeit.webparts.Writable;
import org.wahlzeit.webparts.WritableList;

import java.util.logging.Logger;

/**
 * A handler class for a specific web page.
 */
public class ShowUserHomePageHandler extends AbstractWebPageHandler {
    private static final Logger log = Logger.getLogger(ShowUserHomePageHandler.class.getName());

    /**
     *
     */
    public ShowUserHomePageHandler() {
        initialize(PartUtil.SHOW_USER_HOME_PAGE_FILE, AccessRights.USER);
    }

    /**
     *
     */
    @Override
    protected void makeWebPageBody(UserSession us, WebPart page) {
        Writable part = makeUserProfileForm(us);
        page.addWritable("profile", part);

        User user = (User) us.getClient();
        Photo[] photos = user.getPhotos();
        boolean wasEmpty = true;
        if (photos.length != 0) {
            WritableList list = new WritableList();
            for (Photo photo : photos) {
                // load it from the GurkenPhotoManager to make sure the same copy is used
                photo = PhotoManager.getInstance().getPhotoFromId(photo.getId());
                if (photo == null) {
                    log.warning(LogBuilder.createSystemMessage().
                            addMessage("A cached photo is null which should not happen. It might be cause by a change in the data model").toString());
                    continue;
                }

                if (!photo.getStatus().isDeleted()) {
                    part = makeUserPhotoForm(us, photo);
                    list.append(part);
                    wasEmpty = false;
                }
            }
            page.addWritable("photos", list);
        }

        if (wasEmpty) {
            page.addString("photos", HtmlUtil.asP(us.getClient().getLanguageConfiguration().getNoPhotoUploaded()));
        }
    }

    /**
     *
     */
    protected Writable makeUserProfileForm(UserSession us) {
        WebFormHandler handler = getFormHandler(PartUtil.SHOW_USER_PROFILE_FORM_NAME);
        return handler.makeWebPart(us);
    }

    /**
     *
     */
    protected Writable makeUserPhotoForm(UserSession us, Photo photo) {
        us.setPhotoId(photo.getId());
        WebFormHandler handler = getFormHandler(PartUtil.SHOW_USER_PHOTO_FORM_NAME);
        return handler.makeWebPart(us);
    }

}
