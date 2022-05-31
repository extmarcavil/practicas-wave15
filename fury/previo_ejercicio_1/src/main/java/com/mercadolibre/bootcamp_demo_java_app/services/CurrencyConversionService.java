package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {
	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionService.class);
	private final CurrencyConversionApiService currencyConversionApiService;
	
	@Autowired
	public CurrencyConversionService(CurrencyConversionApiService currencyConversionApiService) {
		this.currencyConversionApiService = currencyConversionApiService;
	}
	
	public Double getCurrencyConversionRatioToUSD(CurrencyEnum sourceCurrency) throws ParseException, RestException {
		Double ratio = currencyConversionApiService.getCurrencyConversion(sourceCurrency, CurrencyEnum.USD).getRatio();
		if (ratio != 0) {
			log.info("Found ratio " + ratio);
		} else {
			log.error("Error");
		}
		return currencyConversionApiService.getCurrencyConversion(sourceCurrency, CurrencyEnum.USD).getRatio();
	}
	
	public Double getCurrencyConversionRatio(CurrencyEnum sourceCurrency, CurrencyEnum destCurrency) throws ParseException, RestException {
		return currencyConversionApiService.getCurrencyConversion(sourceCurrency, destCurrency).getRatio();
	}
}
