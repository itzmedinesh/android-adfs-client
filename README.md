# android-adfs-client
Android java client for authentication against active directory federation service(ADFS) - JWT,BST

# Create ADFS SignOn request
*********************************************************************

```html

SignOnService signOnService = new SignOnServiceImpl();

1. Binary security token

String authRequest = signOnService.createSignOnRequest(domain+"\\"+mUsername, mPassword,
                        SignOnService.TokenTypes.BST_TOKEN_TYPE);	
2. Json Web Token

String authRequest = signOnService.createSignOnRequest(domain+"\\"+mUsername, mPassword,
                        SignOnService.TokenTypes.JWT_TOKEN_TYPE);               

```

# Initialization of java rest client to access SignOn token from ADFS authentication endpoint
*********************************************************************

Add the rest-api-client library dependency into your project from : https://mvnrepository.com/artifact/com.github.itzmedinesh/rest-api-client

Initialize the ADFS endpoint access client template:

```html

String loginSvcUrlTemplate = "{\"url.hostname\":\"sts.test.com\",\"url.port\":\"80\",\"url.resource.path\":\"/adfs/services/trust/13/usernamemixed\",\"url.ssl.enabled\":\"true\"}";

ServiceUrlConfig authSvcUrlConfig = objectMapper.readValue(loginSvcUrlTemplate, ServiceUrlConfig.class);

RestClientTemplate restClientTemplateTemp = new AndroidRestServiceClient().createClientTemplate("LOGIN_ACCESS_TOKEN", authSvcUrlConfig);

Entity<String> postCallInput = Entity.entity(authRequest, "application/soap+xml; charset=utf-8");

String loginresponse = restClientTemplateTemp.create(null, null, postCallInput).readEntity(String.class);

```

# Extract SignOn token
*********************************************************************

```html

1. Binary security token

	BinarySecurityToken bst = signOnService.getBinarySecurityToken(loginresponse);
	
2. Json Web Token

	String jwt = signOnService.getJsonWebToken(loginresponse);	
								
```
