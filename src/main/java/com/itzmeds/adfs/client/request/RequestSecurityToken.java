package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "RequestSecurityToken")
public class RequestSecurityToken {

	@Element(name = "wsp:AppliesTo", required = true)
	protected AppliesTo element1;
	@Element(name = "trust:KeyType", required = true)
	protected String element2;
	@Element(name = "trust:RequestType", required = true)
	protected String element3;
	@Element(name = "trust:TokenType", required = true)
	protected String element4;

	/**
	 * Gets the value of the appliesTo property.
	 * 
	 * @return possible object is {@link AppliesTo }
	 * 
	 */
	public AppliesTo getAppliesTo() {
		return element1;
	}

	/**
	 * Sets the value of the appliesTo property.
	 * 
	 * @param value
	 *            allowed object is {@link AppliesTo }
	 * 
	 */
	public void setAppliesTo(AppliesTo value) {
		this.element1 = value;
	}

	/**
	 * Gets the value of the keyType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getKeyType() {
		return element2;
	}

	/**
	 * Sets the value of the keyType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setKeyType(String value) {
		this.element2 = value;
	}

	/**
	 * Gets the value of the requestType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequestType() {
		return element3;
	}

	/**
	 * Sets the value of the requestType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequestType(String value) {
		this.element3 = value;
	}

	/**
	 * Gets the value of the tokenType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTokenType() {
		return element4;
	}

	/**
	 * Sets the value of the tokenType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTokenType(String value) {
		this.element4 = value;
	}

}
