package com.mercadolibre.bootcamp_demo_java_app.exceptions;

public class ApiError {
	private String error;
	private String message;
	private Integer status;

	public ApiError() {
	}

	public ApiError(String error, String message, Integer status) {
		super();
		this.error = error;
		this.message = message;
		this.status = status;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
