package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "soap:Envelope")
@NamespaceList({ @Namespace(prefix = "soap", reference = "http://www.w3.org/2003/05/soap-envelope"),
		@Namespace(prefix = "a", reference = "http://www.w3.org/2005/08/addressing"),
		@Namespace(prefix = "trust", reference = "http://docs.oasis-open.org/ws-sx/ws-trust/200512"),
		@Namespace(prefix = "wsse", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"),
		@Namespace(prefix = "wsu", reference = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"),
		@Namespace(prefix = "wsp", reference = "http://schemas.xmlsoap.org/ws/2004/09/policy"),
		@Namespace(prefix = "ds", reference = "http://www.w3.org/2000/09/xmldsig#"),
		@Namespace(prefix = "b", reference = "http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd") })
public class Envelope {

	@Element(name = "soap:Header", required = true)
	private Header element1;
	@Element(name = "soap:Body", required = true)
	private Body element2;

	/**
	 * Gets the value of the header property.
	 * 
	 * @return possible object is {@link Header }
	 * 
	 */
	public Header getHeader() {
		return element1;
	}

	/**
	 * Sets the value of the header property.
	 * 
	 * @param value
	 *            allowed object is {@link Header }
	 * 
	 */
	public void setHeader(Header value) {
		this.element1 = value;
	}

	/**
	 * Gets the value of the body property.
	 * 
	 * @return possible object is {@link Body }
	 * 
	 */
	public Body getBody() {
		return element2;
	}

	/**
	 * Sets the value of the body property.
	 * 
	 * @param value
	 *            allowed object is {@link Body }
	 * 
	 */
	public void setBody(Body value) {
		this.element2 = value;
	}

}
