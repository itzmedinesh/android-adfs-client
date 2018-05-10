
package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import com.itzmeds.adfs.client.util.Base64;

@Root(name = "BinarySecurityToken")
public class BinarySecurityToken {

	@Text
	protected String value;
	@Attribute(name = "EncodingType", required = true)
	protected String encodingType;
	@Attribute(name = "ValueType", required = true)
	protected String valueType;
	@Attribute(name = "Id", required = true)
	protected String id;

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is string
	 */
	public String getValue() {
		return new String(Base64.decode(this.value.getBytes(), Base64.DEFAULT));
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the value of the encodingType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEncodingType() {
		return encodingType;
	}

	/**
	 * Sets the value of the encodingType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEncodingType(String value) {
		this.encodingType = value;
	}

	/**
	 * Gets the value of the valueType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValueType() {
		return valueType;
	}

	/**
	 * Sets the value of the valueType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValueType(String value) {
		this.valueType = value;
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
