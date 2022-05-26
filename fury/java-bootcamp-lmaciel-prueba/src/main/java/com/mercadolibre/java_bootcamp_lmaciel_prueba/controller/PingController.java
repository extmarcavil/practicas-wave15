package com.mercadolibre.java_bootcamp_lmaciel_prueba.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for /ping implementation.
 */
@RestController
public class PingController {

  /**
   * @return "pong" String.
   */
  @GetMapping("/ping")
  public String ping() {
    System.out.println("Prueba primer deploy");
    NewRelic.ignoreTransaction();
    return "pong";
  }
}
