package com.mercadolibre.bootcamp_demo_java_app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class CurrencyConversionService {
	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionService.class);
	private CurrencyConversionApiService currencyConversionApiService;
	
	@Autowired
	public CurrencyConversionService(CurrencyConversionApiService currencyConversionApiService) {
		this.currencyConversionApiService = currencyConversionApiService;
	}
	
	public Double getCurrencyConversionRatioToUSD(CurrencyEnum sourceCurrency) throws ParseException, RestException {
		return getCurrencyConversionRatio(sourceCurrency,CurrencyEnum.USD);
	}
	
	public Double getCurrencyConversionRatio(CurrencyEnum sourceCurrency, CurrencyEnum destCurrency) throws ParseException, RestException {
		return currencyConversionApiService.getCurrencyConversion(sourceCurrency, destCurrency).getRatio();
	}
}
