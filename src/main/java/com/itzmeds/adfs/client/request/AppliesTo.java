package com.itzmeds.adfs.client.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "AppliesTo")
public class AppliesTo {

    @Element(name = "a:EndpointReference", required = true)
    protected EndpointReference endpointReference;

    /**
     * Gets the value of the endpointReference property.
     * 
     * @return
     *     possible object is
     *     {@link EndpointReference }
     *     
     */
    public EndpointReference getEndpointReference() {
        return endpointReference;
    }

    /**
     * Sets the value of the endpointReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointReference }
     *     
     */
    public void setEndpointReference(EndpointReference value) {
        this.endpointReference = value;
    }

}
