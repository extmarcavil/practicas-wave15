package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {	
	@JsonProperty("id")
    private String itemId;
	
	@JsonProperty("title")
    private String title;
	
	@JsonProperty("price")
    private Double price;
	
	@JsonProperty("site_id")
    private String siteId;
	
	@JsonProperty("currency_id")
    private CurrencyEnum currencyId;
}