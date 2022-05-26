package com.mercadolibre.gonzalomurias_furytest.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//haciendo un cambio para commitear
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
    NewRelic.ignoreTransaction();
    return "pong";
  }
}
