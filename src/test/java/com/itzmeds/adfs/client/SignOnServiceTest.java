package com.itzmeds.adfs.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.itzmeds.adfs.client.SignOnService.TokenTypes;
import com.itzmeds.adfs.client.response.jwt.BinarySecurityToken;
import com.itzmeds.adfs.client.util.Base64;

public class SignOnServiceTest {

	String TARGET_URL = "https://sts.test.com/adfs/services/trust/13/usernamemixed";

	String CLIENT_ADDRESS = "urn:test:colleague:tasksvcapi";

	SignOnService signOnService;

	@Before
	public void setup() {
		signOnService = new SignOnServiceImpl();
	}

	@Test
	public void testCreateSignOnRequest() throws SignOnException {

		String signOnReq = signOnService.createSignOnRequest("globaldev\\a-ine12350462", "T@5k5erver123",
				TokenTypes.BST_TOKEN_TYPE, TARGET_URL, CLIENT_ADDRESS);

		String expectedRequestXML = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\" xmlns:trust=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:b=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\">\n"
				+ "   <soap:Header>\n"
				+ "      <a:To>https://sts.test.com/adfs/services/trust/13/usernamemixed</a:To>\n"
				+ "      <wsse:Security>\n" + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-1\">\n"
				+ "            <wsse:Username>globaldev\\a-ine12350462</wsse:Username>\n"
				+ "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">T@5k5erver123</wsse:Password>\n"
				+ "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n"
				+ "      <a:Action>http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue</a:Action>\n"
				+ "   </soap:Header>\n" + "   <soap:Body>\n" + "      <trust:RequestSecurityToken>\n"
				+ "         <wsp:AppliesTo>\n" + "            <a:EndpointReference>\n"
				+ "               <a:Address>urn:test:colleague:tasksvcapi</a:Address>\n"
				+ "            </a:EndpointReference>\n" + "         </wsp:AppliesTo>\n"
				+ "         <trust:KeyType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer</trust:KeyType>\n"
				+ "         <trust:RequestType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue</trust:RequestType>\n"
				+ "         <trust:TokenType>urn:ietf:params:oauth:token-type:jwt</trust:TokenType>\n"
				+ "      </trust:RequestSecurityToken>\n" + "   </soap:Body>\n" + "</soap:Envelope>";

		Assert.assertNotNull(signOnReq);
		Assert.assertNotEquals(signOnReq, "");

		Assert.assertEquals(signOnReq, expectedRequestXML);

		signOnReq = signOnService.createSignOnRequest("globaldev\\a-ine12350462", "T@5k5erver123",
				TokenTypes.JWT_TOKEN_TYPE, TARGET_URL, CLIENT_ADDRESS);

		System.out.println(signOnReq);

		expectedRequestXML = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\" xmlns:trust=\"http://docs.oasis-open.org/ws-sx/ws-trust/200512\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:b=\"http://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd\">\n"
				+ "   <soap:Header>\n"
				+ "      <a:To>https://sts.test.com/adfs/services/trust/13/usernamemixed</a:To>\n"
				+ "      <wsse:Security>\n" + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-1\">\n"
				+ "            <wsse:Username>globaldev\\a-ine12350462</wsse:Username>\n"
				+ "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">T@5k5erver123</wsse:Password>\n"
				+ "         </wsse:UsernameToken>\n" + "      </wsse:Security>\n"
				+ "      <a:Action>http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue</a:Action>\n"
				+ "   </soap:Header>\n" + "   <soap:Body>\n" + "      <trust:RequestSecurityToken>\n"
				+ "         <wsp:AppliesTo>\n" + "            <a:EndpointReference>\n"
				+ "               <a:Address>urn:test:colleague:tasksvcapi</a:Address>\n"
				+ "            </a:EndpointReference>\n" + "         </wsp:AppliesTo>\n"
				+ "         <trust:KeyType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer</trust:KeyType>\n"
				+ "         <trust:RequestType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue</trust:RequestType>\n"
				+ "         <trust:TokenType>urn:ietf:params:oauth:token-type:jwt</trust:TokenType>\n"
				+ "      </trust:RequestSecurityToken>\n" + "   </soap:Body>\n" + "</soap:Envelope>" + "";

		Assert.assertEquals(signOnReq, expectedRequestXML);
	}

	@Test
	public void testGetBinarySecurityToken() throws SignOnException {

		String response = "<trust:RequestSecurityTokenResponse><trust:Lifetime><wsu:Created xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2018-03-22T15:39:22.793Z</wsu:Created><wsu:Expires xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">2018-03-22T16:39:22.793Z</wsu:Expires></trust:Lifetime><wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><wsa:EndpointReference xmlns:wsa=\"http://www.w3.org/2005/08/addressing\"><wsa:Address>urn:test:colleague:tasksvcapi</wsa:Address></wsa:EndpointReference></wsp:AppliesTo><trust:RequestedSecurityToken><wsse:BinarySecurityToken wsu:Id=\"_a0e46a43-d1a2-4121-90c5-1c7a2efd03d1-460611FC9E8C4F9A66EE610D8EDC0D02\" ValueType=\"urn:ietf:params:oauth:token-type:jwt\" EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKU1V6STFOaUlzSW5nMWRDSTZJbmhUWTNCNU9ESmZiRzVUVnpCWlJtcDNUV2hmV0VoelMzSkVPQ0o5LmV5SmhkV1FpT2lKMWNtNDZkR1Z6ZERwamIyeHNaV0ZuZFdVNmRHRnphM04yWTJGd2FTSXNJbWx6Y3lJNkltaDBkSEE2THk5emRITXVkR1Z6ZEM1amIyMHZZV1JtY3k5elpYSjJhV05sY3k5MGNuVnpkQ0lzSW1saGRDSTZNVFV5TVRjek16RTJNaXdpWlhod0lqb3hOVEl4TnpNMk56WXlMQ0pHYVhKemRFNWhiV1VpT2lKRWFXNWxjMmdpTENKTVlYTjBUbUZ0WlNJNklsTjFZbkpoYldGdWFXRnVlQ0lzSW1GMWRHaHRaWFJvYjJRaU9pSm9kSFJ3T2k4dmMyTm9aVzFoY3k1dGFXTnliM052Wm5RdVkyOXRMM2R6THpJd01EZ3ZNRFl2YVdSbGJuUnBkSGt2WVhWMGFHVnVkR2xqWVhScGIyNXRaWFJvYjJRdmNHRnpjM2R2Y21RaUxDSmhkWFJvWDNScGJXVWlPaUl5TURFNExUQXpMVEl5VkRFMU9qTTVPakl5TGpjMk1sb2lMQ0oyWlhJaU9pSXhMakFpZlE9PS5IOEZ3eTdpWVlRRnJ0WVFHZk8tTndNY0VDVUZKdjVfVUwwNHpkZ2JnUjVHNC1oRVRVZUVjUDZUUWlnV3V3c3F2a3E4SVFOVXZqcDlERTExVGN1eFFjeUw1YmhsaVU4bWNTaDFYeGt1TjBkUlZXNlNrWEt6Rjd0LUV3ckFiQXRxMjZySlRQdzV2c2J6WFdSVlBiMnU0TU4xSDU3RWh4TVpPSG4yTlpLMWJDMUFXRENKQU0zZ1o0OEc1dS16YjJpdmh0eWZuRmRteUhTNEI1YmU1eWt2SXUxcnMzcldsUU5EMGRJYkxrckh6b3ZBRlJQVlk4a0NBWW1adWdCSTZvcWN2d0tSOTRBbnV0M0Vhclh4VWhFZmp0Mk5XZ3JZVnlNak51OWhHeUJtZHFDWE8zZjhnbXEtLW9rUzJ5ZDJzSkZ1dldWVFY2QUpWTWVvU0pRVUxHZmVFd0E=</wsse:BinarySecurityToken></trust:RequestedSecurityToken><trust:TokenType>urn:ietf:params:oauth:token-type:jwt</trust:TokenType><trust:RequestType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue</trust:RequestType><trust:KeyType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer</trust:KeyType></trust:RequestSecurityTokenResponse>";

		BinarySecurityToken bst = signOnService.getBinarySecurityToken(response);

		String expectedEncodedToken = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKU1V6STFOaUlzSW5nMWRDSTZJbmhUWTNCNU9ESmZiRzVUVnpCWlJtcDNUV2hmV0VoelMzSkVPQ0o5LmV5SmhkV1FpT2lKMWNtNDZkR1Z6ZERwamIyeHNaV0ZuZFdVNmRHRnphM04yWTJGd2FTSXNJbWx6Y3lJNkltaDBkSEE2THk5emRITXVkR1Z6ZEM1amIyMHZZV1JtY3k5elpYSjJhV05sY3k5MGNuVnpkQ0lzSW1saGRDSTZNVFV5TVRjek16RTJNaXdpWlhod0lqb3hOVEl4TnpNMk56WXlMQ0pHYVhKemRFNWhiV1VpT2lKRWFXNWxjMmdpTENKTVlYTjBUbUZ0WlNJNklsTjFZbkpoYldGdWFXRnVlQ0lzSW1GMWRHaHRaWFJvYjJRaU9pSm9kSFJ3T2k4dmMyTm9aVzFoY3k1dGFXTnliM052Wm5RdVkyOXRMM2R6THpJd01EZ3ZNRFl2YVdSbGJuUnBkSGt2WVhWMGFHVnVkR2xqWVhScGIyNXRaWFJvYjJRdmNHRnpjM2R2Y21RaUxDSmhkWFJvWDNScGJXVWlPaUl5TURFNExUQXpMVEl5VkRFMU9qTTVPakl5TGpjMk1sb2lMQ0oyWlhJaU9pSXhMakFpZlE9PS5IOEZ3eTdpWVlRRnJ0WVFHZk8tTndNY0VDVUZKdjVfVUwwNHpkZ2JnUjVHNC1oRVRVZUVjUDZUUWlnV3V3c3F2a3E4SVFOVXZqcDlERTExVGN1eFFjeUw1YmhsaVU4bWNTaDFYeGt1TjBkUlZXNlNrWEt6Rjd0LUV3ckFiQXRxMjZySlRQdzV2c2J6WFdSVlBiMnU0TU4xSDU3RWh4TVpPSG4yTlpLMWJDMUFXRENKQU0zZ1o0OEc1dS16YjJpdmh0eWZuRmRteUhTNEI1YmU1eWt2SXUxcnMzcldsUU5EMGRJYkxrckh6b3ZBRlJQVlk4a0NBWW1adWdCSTZvcWN2d0tSOTRBbnV0M0Vhclh4VWhFZmp0Mk5XZ3JZVnlNak51OWhHeUJtZHFDWE8zZjhnbXEtLW9rUzJ5ZDJzSkZ1dldWVFY2QUpWTWVvU0pRVUxHZmVFd0E=";

		String actualToken = bst.getValue();

		Assert.assertEquals(new String(Base64.decode(expectedEncodedToken.getBytes(), Base64.DEFAULT)), actualToken);
	}

	@Test
	public void testGetJsonWebToken() throws SignOnException {

		String response = "<trust:RequestSecurityTokenResponse>\n" + "<trust:Lifetime>\n"
				+ "<wsu:Created>2018-03-29T08:08:51.866Z</wsu:Created>\n"
				+ "<wsu:Expires>2018-03-29T09:08:51.866Z</wsu:Expires>\n" + " </trust:Lifetime>\n" + "<wsp:AppliesTo>\n"
				+ "<wsa:EndpointReference>\n" + "<wsa:Address>urn:test:colleague:tasksvcapi</wsa:Address>\n"
				+ "</wsa:EndpointReference>\n" + "</wsp:AppliesTo>\n" + "<trust:RequestedSecurityToken>\n"
				+ "<wsse:BinarySecurityToken wsu:Id=\"_d9d0b789-d121-4920-a35e-a61178121429-B0D787A5EC11E1004A3B16BF3385F503\" ValueType=\"urn:ietf:params:oauth:token-type:jwt\" EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKU1V6STFOaUlzSW5nMWRDSTZJbmhUWTNCNU9ESmZiRzVUVnpCWlJtcDNUV2hmV0VoelMzSkVPQ0o5LmV5SmhkV1FpT2lKMWNtNDZkR1Z6ZERwamIyeHNaV0ZuZFdVNmRHRnphM04yWTJGd2FTSXNJbWx6Y3lJNkltaDBkSEE2THk5emRITXVkR1Z6ZEM1amIyMHZZV1JtY3k5elpYSjJhV05sY3k5MGNuVnpkQ0lzSW1saGRDSTZNVFV5TVRjek16RTJNaXdpWlhod0lqb3hOVEl4TnpNMk56WXlMQ0pHYVhKemRFNWhiV1VpT2lKRWFXNWxjMmdpTENKTVlYTjBUbUZ0WlNJNklsTjFZbkpoYldGdWFXRnVlQ0lzSW1GMWRHaHRaWFJvYjJRaU9pSm9kSFJ3T2k4dmMyTm9aVzFoY3k1dGFXTnliM052Wm5RdVkyOXRMM2R6THpJd01EZ3ZNRFl2YVdSbGJuUnBkSGt2WVhWMGFHVnVkR2xqWVhScGIyNXRaWFJvYjJRdmNHRnpjM2R2Y21RaUxDSmhkWFJvWDNScGJXVWlPaUl5TURFNExUQXpMVEl5VkRFMU9qTTVPakl5TGpjMk1sb2lMQ0oyWlhJaU9pSXhMakFpZlE9PS5IOEZ3eTdpWVlRRnJ0WVFHZk8tTndNY0VDVUZKdjVfVUwwNHpkZ2JnUjVHNC1oRVRVZUVjUDZUUWlnV3V3c3F2a3E4SVFOVXZqcDlERTExVGN1eFFjeUw1YmhsaVU4bWNTaDFYeGt1TjBkUlZXNlNrWEt6Rjd0LUV3ckFiQXRxMjZySlRQdzV2c2J6WFdSVlBiMnU0TU4xSDU3RWh4TVpPSG4yTlpLMWJDMUFXRENKQU0zZ1o0OEc1dS16YjJpdmh0eWZuRmRteUhTNEI1YmU1eWt2SXUxcnMzcldsUU5EMGRJYkxrckh6b3ZBRlJQVlk4a0NBWW1adWdCSTZvcWN2d0tSOTRBbnV0M0Vhclh4VWhFZmp0Mk5XZ3JZVnlNak51OWhHeUJtZHFDWE8zZjhnbXEtLW9rUzJ5ZDJzSkZ1dldWVFY2QUpWTWVvU0pRVUxHZmVFd0E=</wsse:BinarySecurityToken>\n"
				+ "</trust:RequestedSecurityToken>\n"
				+ "<trust:TokenType>urn:ietf:params:oauth:token-type:jwt</trust:TokenType>\n"
				+ "<trust:RequestType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue</trust:RequestType>\n"
				+ "<trust:KeyType>http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer</trust:KeyType>\n"
				+ " </trust:RequestSecurityTokenResponse>";

		String actualToken = signOnService.getJsonWebToken(response);

		String expectedToken = "{\"aud\":\"urn:test:colleague:tasksvcapi\",\"iss\":\"http://sts.test.com/adfs/services/trust\",\"iat\":1521733162,\"exp\":1521736762,\"FirstName\":\"Dinesh\",\"LastName\":\"Subramanianx\",\"authmethod\":\"http://schemas.microsoft.com/ws/2008/06/identity/authenticationmethod/password\",\"auth_time\":\"2018-03-22T15:39:22.762Z\",\"ver\":\"1.0\"}";

		Assert.assertEquals(expectedToken, actualToken);
	}

}
