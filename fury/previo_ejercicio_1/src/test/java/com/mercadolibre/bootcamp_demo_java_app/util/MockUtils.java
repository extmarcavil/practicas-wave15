package com.mercadolibre.bootcamp_demo_java_app.util;

import java.io.IOException;
import java.net.URISyntaxException;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.MockResponse;
import com.mercadolibre.restclient.http.ContentType;
import com.mercadolibre.restclient.http.HttpMethod;

public class MockUtils {
	public static void mockItemRequest(String itemId) throws URISyntaxException, IOException {
		mockItemRequest(itemId, 200);
	}
	
	public static void mockItemRequest(String itemId, int statusCode) throws URISyntaxException, IOException {
		byte[] jsonContents = JsonReadUtils.getJsonContent("item_info_" + itemId + ".json");
		MockResponse.builder().withURL("http://fake.api.mercadolibre.com/items/"+itemId).withMethod(HttpMethod.GET)
				.withStatusCode(statusCode)
				.withResponseHeader(ContentType.HEADER_NAME, ContentType.APPLICATION_JSON.toString())
				.withResponseBody(jsonContents).build();
	}
	
	public static void mockCurrencyConversion(CurrencyEnum sourceCurrency) throws URISyntaxException, IOException {
		byte[] jsonContents = JsonReadUtils.getJsonContent("currency_conversion_" + sourceCurrency + ".json");		
		MockResponse.builder().withURL("http://fake.api.mercadolibre.com/currency_conversions/search?from=UYU&to=USD").withMethod(HttpMethod.GET)
				.withStatusCode(200)
				.withResponseHeader(ContentType.HEADER_NAME, ContentType.APPLICATION_JSON.toString())
				.withResponseBody(jsonContents).build();
	}

}
