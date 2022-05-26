package com.mercadolibre.bootcamp_demo_java_app.exceptions;

public class NotFoundException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7577325010001075863L;
	
	private static final String NOT_FOUND_ERROR_CODE = "not_found";

	public NotFoundException(String description) {
		super(NOT_FOUND_ERROR_CODE, description, 404);
	}

}
