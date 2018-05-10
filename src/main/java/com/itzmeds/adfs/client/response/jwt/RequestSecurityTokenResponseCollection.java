
package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "trust:RequestSecurityTokenResponseCollection")
public class RequestSecurityTokenResponseCollection {

	@Element(name = "trust:RequestSecurityTokenResponse", required = true)
	protected RequestSecurityTokenResponse requestSecurityTokenResponse;

	/**
	 * Gets the value of the requestSecurityTokenResponse property.
	 * 
	 * @return possible object is {@link RequestSecurityTokenResponse }
	 * 
	 */
	public RequestSecurityTokenResponse getRequestSecurityTokenResponse() {
		return requestSecurityTokenResponse;
	}

	/**
	 * Sets the value of the requestSecurityTokenResponse property.
	 * 
	 * @param value
	 *            allowed object is {@link RequestSecurityTokenResponse }
	 * 
	 */
	public void setRequestSecurityTokenResponse(RequestSecurityTokenResponse value) {
		this.requestSecurityTokenResponse = value;
	}

}
