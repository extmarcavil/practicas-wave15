package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.exceptions.InternalServerErrorException;
import com.mercadolibre.bootcamp_demo_java_app.exceptions.NotFoundException;
import com.mercadolibre.restclient.RESTPool;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.exception.ParseException;

public abstract class RestClientService {
    protected RESTPool restPool;
    
    public RestClientService() {
    	restPool = RESTPool.builder()
                .withName("rest_pool")
                .build();
    } 
    
	protected <T> T handleApiResponse(Response resp, Class<T> responseClass) throws ParseException {
		int responseStatus = resp.getStatus();
		if (responseStatus / 100 == 2) { // 2xx
			return resp.getData(responseClass);
		} else {
			if (responseStatus == 404) {
				throw new NotFoundException("Element not found");
			} else {
				throw new InternalServerErrorException();
			}
		}
	}
}
