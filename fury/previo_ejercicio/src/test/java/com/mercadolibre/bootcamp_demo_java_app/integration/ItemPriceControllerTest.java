package com.mercadolibre.bootcamp_demo_java_app.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceResponseDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemUSDPriceResponseDTO;
import com.mercadolibre.bootcamp_demo_java_app.util.MockUtils;

class ItemPriceControllerTest extends ControllerTest {

	@Test
	void itemPrice() throws URISyntaxException, IOException {
		String itemId = "MLU467183322";
		MockUtils.mockItemRequest(itemId);
		Double expectedPrice = Double.valueOf("395");

		//curl http://localhost:8080/prices/MLU467183322
		ResponseEntity<ItemPriceResponseDTO> responseEntity = this.testRestTemplate.exchange("/prices/MLU467183322", HttpMethod.GET, this.getDefaultRequestEntity(), ItemPriceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		ItemPriceResponseDTO response = responseEntity.getBody();
		assertEquals(expectedPrice, response.getPrice());
		assertEquals(itemId, response.getItemId());
	}
	
	@Test
	void itemPriceUSD() throws URISyntaxException, IOException {
		String itemId = "MLU467183322";
		MockUtils.mockItemRequest(itemId);
		MockUtils.mockCurrencyConversion(CurrencyEnum.UYU);
		Double expectedUSDPrice = Double.valueOf("8.87640445");

		ResponseEntity<ItemUSDPriceResponseDTO> responseEntity = this.testRestTemplate.exchange("/prices_usd/MLU467183322", HttpMethod.GET, this.getDefaultRequestEntity(), ItemUSDPriceResponseDTO.class);		

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		ItemUSDPriceResponseDTO response = responseEntity.getBody();
		assertEquals(expectedUSDPrice, response.getPriceUsd());
		assertEquals(itemId, response.getItemId());		
	}
	
	@Test
	void itemPriceItemNotFound() throws URISyntaxException, IOException {
		String itemId = "MLU467183323";
		MockUtils.mockItemRequest(itemId,404);

		ResponseEntity<ItemUSDPriceResponseDTO> responseEntity = this.testRestTemplate.exchange("/prices_usd/MLU467183323", HttpMethod.GET, this.getDefaultRequestEntity(), ItemUSDPriceResponseDTO.class);
		
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
