package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Security")
public class Security {

	@Element(name = "wsse:UsernameToken", required = true)
	protected UsernameToken usernameToken;

	/**
	 * Gets the value of the usernameToken property.
	 * 
	 * @return possible object is {@link UsernameToken }
	 * 
	 */
	public UsernameToken getUsernameToken() {
		return usernameToken;
	}

	/**
	 * Sets the value of the usernameToken property.
	 * 
	 * @param value
	 *            allowed object is {@link UsernameToken }
	 * 
	 */
	public void setUsernameToken(UsernameToken value) {
		this.usernameToken = value;
	}

}
