package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body")
public class Body {

	@Element(name = "trust:RequestSecurityToken", required = true)
	protected RequestSecurityToken requestSecurityToken;

	/**
	 * Gets the value of the requestSecurityToken property.
	 * 
	 * @return possible object is {@link RequestSecurityToken }
	 * 
	 */
	public RequestSecurityToken getRequestSecurityToken() {
		return requestSecurityToken;
	}

	/**
	 * Sets the value of the requestSecurityToken property.
	 * 
	 * @param value
	 *            allowed object is {@link RequestSecurityToken }
	 * 
	 */
	public void setRequestSecurityToken(RequestSecurityToken value) {
		this.requestSecurityToken = value;
	}

}
