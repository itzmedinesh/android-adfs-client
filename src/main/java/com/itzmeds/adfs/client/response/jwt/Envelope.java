package com.itzmeds.adfs.client.response.jwt;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "s:Envelope")
@NamespaceList({ @Namespace(prefix = "s", reference = "http://www.w3.org/2003/05/soap-envelope"),
		@Namespace(prefix = "a", reference = "http://www.w3.org/2005/08/addressing"),
		@Namespace(prefix = "wsa", reference = "http://www.w3.org/2005/08/addressing"),
		@Namespace(prefix = "trust", reference = "http://docs.oasis-open.org/ws-sx/ws-trust/200512"),
		@Namespace(prefix = "wsse", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
		@Namespace(prefix = "o", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
		@Namespace(prefix = "wsu", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"),
		@Namespace(prefix = "u", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"),
		@Namespace(prefix = "wsp", reference = "http://schemas.xmlsoap.org/ws/2004/09/policy"),
		@Namespace(prefix = "ds", reference = "http://www.w3.org/2000/09/xmldsig#"),
		@Namespace(prefix = "b", reference = "http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd") })
public class Envelope {

	@Element(name = "s:Header", required = true)
	@Namespace(prefix = "s", reference = "http://www.w3.org/2003/05/soap-envelope")
	protected Header header;
	@Element(name = "s:Body", required = true)
	protected Body body;

	/**
	 * Gets the value of the header property.
	 * 
	 * @return possible object is {@link Header }
	 * 
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * Sets the value of the header property.
	 * 
	 * @param value
	 *            allowed object is {@link Header }
	 * 
	 */
	public void setHeader(Header value) {
		this.header = value;
	}

	/**
	 * Gets the value of the body property.
	 * 
	 * @return possible object is {@link Body }
	 * 
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * Sets the value of the body property.
	 * 
	 * @param value
	 *            allowed object is {@link Body }
	 * 
	 */
	public void setBody(Body value) {
		this.body = value;
	}

}
