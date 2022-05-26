package com.mercadolibre.bootcamp_demo_java_app.integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.bootcamp_demo_java_app.util.MockUtils;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

public class ItemsApiServiceTest extends IntegrationTest {
	@Autowired
	ItemsApiService itemsApiService;
	
	@Test
	public void testGetItem() throws URISyntaxException, IOException, ParseException, RestException {
		String itemId = "MLU467183322";
		MockUtils.mockItemRequest(itemId);
		double expectedPrice = Double.valueOf("395");
		ItemDTO expectedItemDTO = new ItemDTO(itemId, "Pila Recargable Philips Aaa 950mah Blister X4 Pilas Triple A", expectedPrice, "MLU", CurrencyEnum.UYU);
		
		assertEquals(expectedItemDTO, itemsApiService.getItemInfo(itemId));
	}	
}
