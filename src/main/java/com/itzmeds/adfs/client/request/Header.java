package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Header")
public class Header {

	@Element(name = "a:To", required = true)
	protected String element1;
	@Element(name = "wsse:Security", required = true)
	protected Security element2;
	@Element(name = "a:Action", required = true)
	protected String element3;

	/**
	 * Gets the value of the to property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTo() {
		return element1;
	}

	/**
	 * Sets the value of the to property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTo(String value) {
		this.element1 = value;
	}

	/**
	 * Gets the value of the security property.
	 * 
	 * @return possible object is {@link Security }
	 * 
	 */
	public Security getSecurity() {
		return element2;
	}

	/**
	 * Sets the value of the security property.
	 * 
	 * @param value
	 *            allowed object is {@link Security }
	 * 
	 */
	public void setSecurity(Security value) {
		this.element2 = value;
	}

	/**
	 * Gets the value of the action property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAction() {
		return element3;
	}

	/**
	 * Sets the value of the action property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAction(String value) {
		this.element3 = value;
	}

}
