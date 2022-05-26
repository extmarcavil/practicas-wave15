package com.mercadolibre.bootcamp_demo_java_app.api.services;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class CurrencyConversionApiService extends RestClientService{
    @Value("${meli.base.url}")
    private String baseUrl;

    private String currencyConversionApiBaseUrl;
    
    private RestClient currencyConversionApiClient;

    public CurrencyConversionApiService() throws IOException{
    	super();
    }
    
    @PostConstruct
    public void init() throws IOException {
    	currencyConversionApiBaseUrl = String.format("%s/currency_conversions/search",baseUrl);
    	currencyConversionApiClient = RestClient.builder()
        	    .withPool(restPool)
        	    .build();
    }

    public CurrencyConversionDTO getCurrencyConversion(CurrencyEnum sourceCurrency, CurrencyEnum destCurrency) throws RestException, ParseException {
        String conversionUrl = currencyConversionApiBaseUrl + "?from=" + sourceCurrency + "&to=" + destCurrency;
        Response resp = currencyConversionApiClient.get(conversionUrl);
        return handleApiResponse(resp, CurrencyConversionDTO.class);
	}
}
