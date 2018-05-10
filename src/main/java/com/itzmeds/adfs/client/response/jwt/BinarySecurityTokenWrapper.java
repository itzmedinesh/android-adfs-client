
package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "RequestedSecurityToken")
public class BinarySecurityTokenWrapper {

	@Element(name = "BinarySecurityToken", required = true)
	protected BinarySecurityToken binarySecurityToken;

	/**
	 * Gets the value of the binarySecurityToken property.
	 * 
	 * @return possible object is {@link BinarySecurityToken }
	 * 
	 */
	public BinarySecurityToken getBinarySecurityToken() {
		return binarySecurityToken;
	}

	/**
	 * Sets the value of the binarySecurityToken property.
	 * 
	 * @param value
	 *            allowed object is {@link BinarySecurityToken }
	 * 
	 */
	public void setBinarySecurityToken(BinarySecurityToken value) {
		this.binarySecurityToken = value;
	}

}
