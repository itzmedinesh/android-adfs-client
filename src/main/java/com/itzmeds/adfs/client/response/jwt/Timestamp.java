package com.itzmeds.adfs.client.response.jwt;

import javax.xml.datatype.XMLGregorianCalendar;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "u:Timestamp")
public class Timestamp {

	@Element(name = "u:Created", required = true)
	protected XMLGregorianCalendar created;
	@Element(name = "u:Expires", required = true)
	protected XMLGregorianCalendar expires;
	@Attribute(name = "u:Id", required = true)
	protected String id;

	/**
	 * Gets the value of the created property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getCreated() {
		return created;
	}

	/**
	 * Sets the value of the created property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreated(XMLGregorianCalendar value) {
		this.created = value;
	}

	/**
	 * Gets the value of the expires property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExpires() {
		return expires;
	}

	/**
	 * Sets the value of the expires property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExpires(XMLGregorianCalendar value) {
		this.expires = value;
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
