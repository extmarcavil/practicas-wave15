package com.mercadolibre.bootcamp_api_deportistas.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.bootcamp_api_deportistas.beans.RandomSampleBean;
import com.mercadolibre.bootcamp_api_deportistas.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
