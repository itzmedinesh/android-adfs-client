package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "UsernameToken")
public class UsernameToken {

	@Element(name = "wsse:Username", required = true)
	protected String element1;
	@Element(name = "wsse:Password", required = true)
	protected Password element2;
	@Attribute(name = "wsu:Id", required = true)
	protected String id;

	/**
	 * Gets the value of the username property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsername() {
		return element1;
	}

	/**
	 * Sets the value of the username property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsername(String value) {
		this.element1 = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link Password }
	 * 
	 */
	public Password getPassword() {
		return element2;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link Password }
	 * 
	 */
	public void setPassword(Password value) {
		this.element2 = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

}
