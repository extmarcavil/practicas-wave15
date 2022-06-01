package com.mercadolibre.bootcamp_demo_java_app.integration;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PingControllerTest extends ControllerTest {

	@Test
	void ping() {
		ResponseEntity<String> responseEntity = this.testRestTemplate.exchange("/ping", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("pong", responseEntity.getBody());
	}
}
