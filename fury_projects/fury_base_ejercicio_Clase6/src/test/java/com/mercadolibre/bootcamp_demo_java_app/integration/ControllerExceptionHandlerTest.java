package com.mercadolibre.bootcamp_demo_java_app.integration;

import com.mercadolibre.bootcamp_demo_java_app.controller.PingController;
import com.mercadolibre.bootcamp_demo_java_app.exceptions.ApiError;
import com.mercadolibre.bootcamp_demo_java_app.exceptions.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

class ControllerExceptionHandlerTest extends ControllerTest {
	@SpyBean
	private PingController pingController;

	@Test
	public void notFound() {
		// When
		ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange("/fake", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

		// Then
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void testUnhandledException() {
		// Given
		doThrow(new RuntimeException()).when(pingController)
				.ping();

		// When
		ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange("/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

		// Then
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	public void testApiExceptionError() {
		// Given
		doThrow(new ApiException("error", "error", HttpStatus.INTERNAL_SERVER_ERROR.value())).when(pingController)
				.ping();

		// When
		ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange("/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

		// Then
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	public void testApiExceptionWarn() {
		// Given
		doThrow(new ApiException("warn", "warn", HttpStatus.BAD_REQUEST.value())).when(pingController)
				.ping();

		// When
		ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange("/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

		// Then
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

}
