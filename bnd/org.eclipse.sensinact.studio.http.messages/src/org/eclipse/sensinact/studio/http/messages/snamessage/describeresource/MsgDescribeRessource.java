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
package org.eclipse.sensinact.studio.http.messages.snamessage.describeresource;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgCategory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;

/**
 * @author Etienne Gandrille
 */
public class MsgDescribeRessource extends MsgSensinact {
	public static final String KEY = "DESCRIBE_RESOURCE";

	private String uri;
	private int statusCode;
	private ObjectResponse response;
	
	@Override
	public MsgCategory getCategory() {
		return MsgCategory.OTHER;
	}
	
	public MsgDescribeRessource() {
		super(KEY);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public ObjectResponse getResponse() {
		return response;
	}

	public void setResponse(ObjectResponse response) {
		this.response = response;
	}

	public static String getKey() {
		return KEY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + statusCode;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		MsgDescribeRessource other = (MsgDescribeRessource) obj;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (statusCode != other.statusCode)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MsgDescribeRessource [uri=" + uri + ", statusCode=" + statusCode + ", response=" + response + "]";
	}
}
