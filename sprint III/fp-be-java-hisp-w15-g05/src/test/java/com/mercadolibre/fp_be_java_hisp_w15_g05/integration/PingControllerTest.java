package com.mercadolibre.fp_be_java_hisp_w15_g05.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PingControllerTest extends ControllerTest {

  @Test
  void ping() {
    ResponseEntity<String> responseEntity =
        this.testRestTemplate.exchange(
            "/ping", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("pong", responseEntity.getBody());
  }
}
