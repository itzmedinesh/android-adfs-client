
package com.itzmeds.adfs.client.response.jwt;

import javax.xml.datatype.XMLGregorianCalendar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Lifetime")
public class Lifetime {

	@Element(name = "Created", required = true)
	protected String created;
	
	@Element(name = "Expires", required = true)
	protected String expires;

	/**
	 * Gets the value of the created property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Sets the value of the created property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreated(String value) {
		this.created = value;
	}

	/**
	 * Gets the value of the expires property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public String getExpires() {
		return expires;
	}

	/**
	 * Sets the value of the expires property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExpires(String value) {
		this.expires = value;
	}

}
