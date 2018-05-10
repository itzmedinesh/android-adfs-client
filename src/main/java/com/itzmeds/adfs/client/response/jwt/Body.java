
package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "s:Body")
public class Body {

	@Element(name = "trust:RequestSecurityTokenResponseCollection", required = true)
	protected RequestSecurityTokenResponseCollection requestSecurityTokenResponseCollection;

	/**
	 * Gets the value of the requestSecurityTokenResponseCollection property.
	 * 
	 * @return possible object is {@link RequestSecurityTokenResponseCollection }
	 * 
	 */
	public RequestSecurityTokenResponseCollection getRequestSecurityTokenResponseCollection() {
		return requestSecurityTokenResponseCollection;
	}

	/**
	 * Sets the value of the requestSecurityTokenResponseCollection property.
	 * 
	 * @param value
	 *            allowed object is {@link RequestSecurityTokenResponseCollection }
	 * 
	 */
	public void setRequestSecurityTokenResponseCollection(RequestSecurityTokenResponseCollection value) {
		this.requestSecurityTokenResponseCollection = value;
	}

}
