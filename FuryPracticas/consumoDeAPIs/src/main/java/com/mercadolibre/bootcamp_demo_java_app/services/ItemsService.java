package com.mercadolibre.bootcamp_demo_java_app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;
	
	private CurrencyConversionService currencyConversionService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService, CurrencyConversionService currencyConversionService) {
		this.itemsApiService = itemsApiService;
		this.currencyConversionService = currencyConversionService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo.getPrice();
	}

	public Double getItemUSDPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		Double conversionRate = currencyConversionService.getCurrencyConversionRatioToUSD(itemInfo.getCurrencyId());
		return conversionRate * itemInfo.getPrice();
	}
}
