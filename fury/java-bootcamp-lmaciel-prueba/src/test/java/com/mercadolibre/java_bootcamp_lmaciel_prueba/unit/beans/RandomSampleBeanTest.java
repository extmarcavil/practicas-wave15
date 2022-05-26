package com.mercadolibre.java_bootcamp_lmaciel_prueba.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.java_bootcamp_lmaciel_prueba.beans.RandomSampleBean;
import com.mercadolibre.java_bootcamp_lmaciel_prueba.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
