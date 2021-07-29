/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.webapp.outdoor;

import org.eclipse.sensinact.studio.http.services.server.RouteUtil;
import org.eclipse.sensinact.studio.webapp.outdoor.content.OutdoorInit;
import org.eclipse.sensinact.studio.webapp.outdoor.content.OutdoorResources;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Etienne Gandrille
 */
@Component
public class Startup{

	public static final String INIT_PATH = "/webapp/outdoor/init";
	public static final String STATIC_PATH = "/webapp/outdoor/static";
	public static final String BUNDLE_PATHS[] = { INIT_PATH, STATIC_PATH };
	private OutdoorResources outdoorResources;

	@Activate
	public void activate() {
		outdoorResources = new OutdoorResources();
		RouteUtil.attachRoute(INIT_PATH, OutdoorInit.class);
		RouteUtil.attachRoute(STATIC_PATH, outdoorResources);
	}

	@Deactivate
	public void deactivate() {
		RouteUtil.attachRoute(INIT_PATH, OutdoorInit.class);
		RouteUtil.attachRoute(STATIC_PATH, outdoorResources);
	}
}
