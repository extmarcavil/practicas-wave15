package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionDTO {	
	@JsonProperty("ratio")
    private Double ratio;
	
	@JsonProperty("currency_base")
	private CurrencyEnum baseCurrency;
	
	@JsonProperty("currency_quote")
	private CurrencyEnum destCurrency;
}