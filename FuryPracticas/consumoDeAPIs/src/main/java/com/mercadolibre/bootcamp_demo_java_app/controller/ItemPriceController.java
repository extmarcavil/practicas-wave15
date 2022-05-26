package com.mercadolibre.bootcamp_demo_java_app.controller;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceResponseDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemUSDPriceResponseDTO;
import com.mercadolibre.bootcamp_demo_java_app.services.ItemsService;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPriceController {
	ItemsService itemsService;
	
	@Autowired
	public ItemPriceController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@GetMapping("/prices/{itemId}")
	public ItemPriceResponseDTO getItemPrice(@PathVariable String itemId) throws ParseException, RestException {
		Double price = itemsService.getItemPrice(itemId);
		return new ItemPriceResponseDTO(itemId, price);
	}
	
	@GetMapping("/prices_usd/{itemId}")
	public ItemUSDPriceResponseDTO getItemPriceUSD(@PathVariable String itemId) throws ParseException, RestException {
		Double usdPrice = itemsService.getItemUSDPrice(itemId);
		return new ItemUSDPriceResponseDTO(itemId, usdPrice);
	}

}
