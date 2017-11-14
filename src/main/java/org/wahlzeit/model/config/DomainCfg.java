/*
 *  Copyright
 *
 *  Classname: DomainCfg
 *  Author: Tango1266
 *  Version: 14.11.17 07:46
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

package org.wahlzeit.model.config;

import org.wahlzeit.model.gurkenDomain.GurkenPhoto;
import org.wahlzeit.model.gurkenDomain.GurkenPhotoFactory;
import org.wahlzeit.model.gurkenDomain.GurkenPhotoManager;
import org.wahlzeit.services.CloudDataBase;

/**
 * Single Access Point to the domain specif Logic. In order to change the entire domain of Wahlzeit,
 * just change here the domain files.
 */
public class DomainCfg {

    public static GurkenPhotoManager PhotoManager = GurkenPhotoManager.getInstance();
    public static GurkenPhotoFactory PhotoFactory = GurkenPhotoFactory.getInstance();

    /**
     * object registration of google objectify service
     */
    public static void registerDomainObjects() {
        registerGurkenDomainObjects();
    }

    private static void registerGurkenDomainObjects() {
        CloudDataBase.getMgmtActions().register(GurkenPhoto.class);
    }
}