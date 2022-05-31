package com.mercadolibre.gmurias_deportistas_test.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.gmurias_deportistas_test.beans.RandomSampleBean;
import com.mercadolibre.gmurias_deportistas_test.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
