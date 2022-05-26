package com.mercadolibre.gonzalomurias_furytest.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.gonzalomurias_furytest.beans.RandomSampleBean;
import com.mercadolibre.gonzalomurias_furytest.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
