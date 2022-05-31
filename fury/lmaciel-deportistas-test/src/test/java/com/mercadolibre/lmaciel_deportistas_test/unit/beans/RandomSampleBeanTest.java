package com.mercadolibre.lmaciel_deportistas_test.unit.beans;

import com.mercadolibre.lmaciel_deportistas_test.beans.RandomSampleBean;
import com.mercadolibre.lmaciel_deportistas_test.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
