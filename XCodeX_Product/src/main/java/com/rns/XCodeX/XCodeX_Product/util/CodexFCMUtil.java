package com.rns.XCodeX.XCodeX_Product.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rns.XCodeX.XCodeX_Product.domain.CodexNotification;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class CodexFCMUtil {
	
	public static void postNotification(CodexNotification request) throws IOException, JsonGenerationException, JsonMappingException {
		//String url = BillPropertyUtil.getProperty(BillPropertyUtil.FCM_URL);
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);

		WebResource webResource = client.resource("https://fcm.googleapis.com/fcm/send");
		System.out.println("Calling FCM URL request:" + new ObjectMapper().writeValueAsString(request));

		//AAAAZoCVy88:APA91bE-iQHViwA4v2mdhaYU7rtZOQY-OxNXVe7Kc1nxdpD4Yp-Y175pw_eN5-DgchUOV0bL4ef7OznxtSgu8yiQbWgFny4BFPOUlvKSd3RXvehZuCdcfgwRdch0U4xBgxq2nnh2TVW_
		String key = "AAAAjb1urco:APA91bHKn4YluHGv9OX_WhngMQQJuC6LzH1Zfenbp89ykMl_i2AMirZarn9uz6JKjel6BYKxp6sgf4kYYS0y0w1ryfRliw2hB9mnvbNezTblFyzziCmEqNROAC0hZUTrxPbomyBbuYCK";
		ClientResponse response = webResource.type("application/json").header("Authorization", "key=" + key).post(ClientResponse.class, request);

		if (response.getStatus() != 200) {
			//LoggingUtil.logMessage("Failed in FCM URL : HTTP error code : " + response.getStatus(), LoggingUtil.smsLogger);
		}
		String output = response.getEntity(String.class);
		System.out.println("Response from FCM => " + output);
		//LoggingUtil.logMessage("Output from FCM URL : " + response.getStatus() + ".... \n " + output, LoggingUtil.smsLogger);
	}

}
