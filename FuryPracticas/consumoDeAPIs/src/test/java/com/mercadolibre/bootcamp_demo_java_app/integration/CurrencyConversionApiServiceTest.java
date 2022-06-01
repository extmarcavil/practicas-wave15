package com.mercadolibre.bootcamp_demo_java_app.integration;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.util.MockUtils;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class CurrencyConversionApiServiceTest extends IntegrationTest {
	@Autowired
	CurrencyConversionApiService currenctConversionApiService;
	
	@Test
	public void testGetCurrencyConversion() throws URISyntaxException, IOException, ParseException, RestException {
		CurrencyEnum sourceCurrency = CurrencyEnum.UYU;
		MockUtils.mockCurrencyConversion(sourceCurrency);
		Double expectedRatio = Double.valueOf("0.02247191");
		CurrencyConversionDTO expectedCurrenctConversion = new CurrencyConversionDTO(expectedRatio, CurrencyEnum.UYU, CurrencyEnum.USD);
		
		//assertEquals(expectedCurrenctConversion, currenctConversionApiService.getCurrencyConversion(sourceCurrency, CurrencyEnum.USD));
	}	
}
