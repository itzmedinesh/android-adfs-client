package com.itzmeds.adfs.client.response.jwt;

import java.math.BigInteger;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "o:Security")
public class Security {

	@Element(name = "u:Timestamp", required = true)
	protected Timestamp timestamp;
	@Attribute(name = "s:mustUnderstand", required = true)
	protected BigInteger mustUnderstand;

	/**
	 * Gets the value of the timestamp property.
	 * 
	 * @return possible object is {@link Timestamp }
	 * 
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the value of the timestamp property.
	 * 
	 * @param value
	 *            allowed object is {@link Timestamp }
	 * 
	 */
	public void setTimestamp(Timestamp value) {
		this.timestamp = value;
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
