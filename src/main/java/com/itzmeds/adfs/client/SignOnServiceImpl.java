package com.itzmeds.adfs.client;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.StringTokenizer;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.itzmeds.adfs.client.request.AppliesTo;
import com.itzmeds.adfs.client.request.Body;
import com.itzmeds.adfs.client.request.EndpointReference;
import com.itzmeds.adfs.client.request.Envelope;
import com.itzmeds.adfs.client.request.Header;
import com.itzmeds.adfs.client.request.Password;
import com.itzmeds.adfs.client.request.RequestSecurityToken;
import com.itzmeds.adfs.client.request.Security;
import com.itzmeds.adfs.client.request.UsernameToken;
import com.itzmeds.adfs.client.response.jwt.BinarySecurityToken;
import com.itzmeds.adfs.client.response.jwt.RequestSecurityTokenResponse;
import com.itzmeds.adfs.client.util.Base64;

public class SignOnServiceImpl implements SignOnService {

	@Override
	public String createSignOnRequest(String username, String password, TokenTypes tokenType, String targetUrl,
			String clientAddress) throws SignOnException {

		Envelope envelope = new Envelope();
		Header header = new Header();
		header.setAction(ACTION_URL);
		header.setTo(targetUrl);

		Security security = new Security();
		UsernameToken usernameToken = new UsernameToken();
		usernameToken.setId("UsernameToken-1");

		Password passwordObj = new Password();
		passwordObj.setType(PASSWORD_TYPE);
		passwordObj.setContent(password);

		usernameToken.setPassword(passwordObj);
		usernameToken.setUsername(username);

		security.setUsernameToken(usernameToken);

		header.setSecurity(security);

		Body body = new Body();

		RequestSecurityToken reqSecToken = new RequestSecurityToken();
		reqSecToken.setKeyType(KEY_TYPE);
		reqSecToken.setRequestType(REQUEST_TYPE);
		reqSecToken.setTokenType(tokenType.toString());

		AppliesTo appliesTo = new AppliesTo();

		EndpointReference endpointRef = new EndpointReference();
		endpointRef.setAddress(clientAddress);

		appliesTo.setEndpointReference(endpointRef);

		reqSecToken.setAppliesTo(appliesTo);

		body.setRequestSecurityToken(reqSecToken);

		envelope.setHeader(header);
		envelope.setBody(body);

		StringWriter requestWriter = new StringWriter();

		try {

			Serializer serializer = new Persister();

			serializer.write(envelope, requestWriter);

		} catch (Throwable e) {
			throw new SignOnException(e);
		}

		return requestWriter.toString();

	}

	@Override
	public BinarySecurityToken getBinarySecurityToken(String response) throws SignOnException {
		int binaryTokenStartIndex = response.indexOf("<trust:RequestSecurityTokenResponse>") + 36;
		int binaryTokenEndIndex = response.indexOf("</trust:RequestSecurityTokenResponse>") + 37;

		String jsonWebTokenStr = "<trust:RequestSecurityTokenResponse xmlns:trust=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"
				+ response.substring(binaryTokenStartIndex, binaryTokenEndIndex);

		RequestSecurityTokenResponse securityTokenResponse = null;

		try {
			Serializer serializer = new Persister();

			securityTokenResponse = serializer.read(RequestSecurityTokenResponse.class,
					new StringReader(jsonWebTokenStr));
		} catch (Throwable e) {
			e.printStackTrace();
			throw new SignOnException(e);
		}

		return securityTokenResponse != null && securityTokenResponse.getRequestedSecurityToken() != null
				? securityTokenResponse.getRequestedSecurityToken().getBinarySecurityToken()
				: null;
	}

	@Override
	public String getJsonWebToken(String response) throws SignOnException {

		BinarySecurityToken bst = getBinarySecurityToken(response);

		String jsonWebToken = null;

		if (bst != null) {

			String binarySecToken = bst.getValue();

			StringTokenizer binSecTokenizer = new StringTokenizer(binarySecToken, ".");

			binSecTokenizer.nextToken();

			String encodedJWT = binSecTokenizer.nextToken();

			jsonWebToken = new String(Base64.decode(encodedJWT.getBytes(), Base64.DEFAULT));
		}

		return jsonWebToken;
	}

}
