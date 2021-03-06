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
package org.eclipse.sensinact.studio.model.resource.utils;

/**
 * @author Etienne Gandrille
 */
public class DeviceDescriptor extends AbstractDescriptor{

	private final String device;
	private String icon;
	private String location;

	public DeviceDescriptor(String gateway, String device) {
		super(gateway);
		this.device = device;
	}
	
	public String getGateway() {
		return gateway;
	}

	public String getDevice() {
		return device;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location=location;
	}
	
	@Override
	public String toString() {
		return getGateway() + "/" + getDevice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceDescriptor other = (DeviceDescriptor) obj;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		return true;
	}
	
	@Override
	public String getPath() {
		return  "/" + getDevice();
	}
	
}
