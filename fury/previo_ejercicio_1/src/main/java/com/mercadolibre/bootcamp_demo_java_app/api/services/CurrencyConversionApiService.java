package com.mercadolibre.bootcamp_demo_java_app.api.services;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyRatioDTO;
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
        //UNIMPLEMENTED
        Map<String, String> params = Map.of("from",sourceCurrency.name(), "to", destCurrency.name());
        CurrencyRatioDTO ratio = handleApiResponse(currencyConversionApiClient
                                                            .withParameters(params)
                                                            .get(currencyConversionApiBaseUrl),
                                                    CurrencyRatioDTO.class);
        return new CurrencyConversionDTO(ratio.getRatio(), sourceCurrency, destCurrency);
	}
}
