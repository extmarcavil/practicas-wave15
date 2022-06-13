package com.mercadolibre.fp_be_java_hisp_w15_g05.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

import com.mercadolibre.fp_be_java_hisp_w15_g05.controller.PingController;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.ApiError;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ControllerExceptionHandlerTest extends ControllerTest {

  @SpyBean
  private PingController pingController;

  @Test
  void notFound() {
    // When
    ResponseEntity<ApiError> responseEntity =
        this.testRestTemplate.exchange(
            "/fake", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

    // Then
    assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
  }

  @Test
  void testUnhandledException() {
    // Given
    doThrow(new RuntimeException()).when(pingController).ping();

    // When
    ResponseEntity<ApiError> responseEntity =
        this.testRestTemplate.exchange(
            "/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

    // Then
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
  }

  @Test
  void testApiExceptionError() {
    // Given
    doThrow(new ApiException("error", "error", HttpStatus.INTERNAL_SERVER_ERROR.value()))
        .when(pingController)
        .ping();

    // When
    ResponseEntity<ApiError> responseEntity =
        this.testRestTemplate.exchange(
            "/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

    // Then
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
  }

  @Test
  void testApiExceptionWarn() {
    // Given
    doThrow(new ApiException("warn", "warn", HttpStatus.BAD_REQUEST.value()))
        .when(pingController)
        .ping();

    // When
    ResponseEntity<ApiError> responseEntity =
        this.testRestTemplate.exchange(
            "/ping", HttpMethod.GET, this.getDefaultRequestEntity(), ApiError.class);

    // Then
    assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
  }
}
