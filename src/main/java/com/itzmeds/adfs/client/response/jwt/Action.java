package com.itzmeds.adfs.client.response.jwt;

import java.math.BigInteger;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Action")
public class Action {

	@Text
	protected String value;
	@Attribute(name = "s:mustUnderstand", required = true)
	protected BigInteger mustUnderstand;

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the value of the mustUnderstand property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMustUnderstand() {
		return mustUnderstand;
	}

	/**
	 * Sets the value of the mustUnderstand property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMustUnderstand(BigInteger value) {
		this.mustUnderstand = value;
	}

}
