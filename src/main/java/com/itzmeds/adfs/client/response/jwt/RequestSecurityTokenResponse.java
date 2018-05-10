package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({ @Namespace(prefix = "wsa", reference = "http://www.w3.org/2005/08/addressing"),
		@Namespace(prefix = "trust", reference = "http://docs.oasis-open.org/ws-sx/ws-trust/200512"),
		@Namespace(prefix = "wsse", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
		@Namespace(prefix = "wsu", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd") })

@Root(name = "RequestSecurityTokenResponse")
public class RequestSecurityTokenResponse {
	@Element(name = "Lifetime", required = true)
	protected Lifetime lifetime;

	@Element(name = "AppliesTo", required = true)
	protected AppliesTo appliesTo;

	@Element(name = "RequestedSecurityToken", required = true)
	protected BinarySecurityTokenWrapper requestedSecurityToken;

	@Element(name = "TokenType", required = true)
	protected String tokenType;

	@Element(name = "RequestType", required = true)
	protected String requestType;

	@Element(name = "KeyType", required = true)
	protected String keyType;

	/**
	 * Gets the value of the lifetime property.
	 * 
	 * @return possible object is {@link Lifetime }
	 * 
	 */
	public Lifetime getLifetime() {
		return lifetime;
	}

	/**
	 * Sets the value of the lifetime property.
	 * 
	 * @param value
	 *            allowed object is {@link Lifetime }
	 * 
	 */
	public void setLifetime(Lifetime value) {
		this.lifetime = value;
	}

	/**
	 * Gets the value of the appliesTo property.
	 * 
	 * @return possible object is {@link AppliesTo }
	 * 
	 */
	public AppliesTo getAppliesTo() {
		return appliesTo;
	}

	/**
	 * Sets the value of the appliesTo property.
	 * 
	 * @param value
	 *            allowed object is {@link AppliesTo }
	 * 
	 */
	public void setAppliesTo(AppliesTo value) {
		this.appliesTo = value;
	}

	/**
	 * Gets the value of the requestedSecurityToken property.
	 * 
	 * @return possible object is {@link BinarySecurityTokenWrapper }
	 * 
	 */
	public BinarySecurityTokenWrapper getRequestedSecurityToken() {
		return requestedSecurityToken;
	}

	/**
	 * Sets the value of the requestedSecurityToken property.
	 * 
	 * @param value
	 *            allowed object is {@link BinarySecurityTokenWrapper }
	 * 
	 */
	public void setRequestedSecurityToken(BinarySecurityTokenWrapper value) {
		this.requestedSecurityToken = value;
	}

	/**
	 * Gets the value of the tokenType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * Sets the value of the tokenType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTokenType(String value) {
		this.tokenType = value;
	}

	/**
	 * Gets the value of the requestType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * Sets the value of the requestType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequestType(String value) {
		this.requestType = value;
	}

	/**
	 * Gets the value of the keyType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getKeyType() {
		return keyType;
	}

	/**
	 * Sets the value of the keyType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setKeyType(String value) {
		this.keyType = value;
	}

}
