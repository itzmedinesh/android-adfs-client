package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "s:Header")
public class Header {

	@Element(name = "a:Action", required = true)
	protected Action action;
	@Element(name = "o:Security", required = true)
	protected Security security;

	/**
	 * Gets the value of the action property.
	 * 
	 * @return possible object is {@link Action }
	 * 
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the value of the action property.
	 * 
	 * @param value
	 *            allowed object is {@link Action }
	 * 
	 */
	public void setAction(Action value) {
		this.action = value;
	}

	/**
	 * Gets the value of the security property.
	 * 
	 * @return possible object is {@link Security }
	 * 
	 */
	public Security getSecurity() {
		return security;
	}

	/**
	 * Sets the value of the security property.
	 * 
	 * @param value
	 *            allowed object is {@link Security }
	 * 
	 */
	public void setSecurity(Security value) {
		this.security = value;
	}

}
