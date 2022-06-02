package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ItemUSDPriceResponseDTO {
	@JsonProperty("item_id")
	private String itemId;
	
	@JsonProperty("price_usd")
	private Double priceUsd;
}
