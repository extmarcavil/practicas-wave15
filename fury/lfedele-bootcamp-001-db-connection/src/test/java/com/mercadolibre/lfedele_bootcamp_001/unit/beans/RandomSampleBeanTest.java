package com.mercadolibre.lfedele_bootcamp_001.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.lfedele_bootcamp_001.beans.RandomSampleBean;
import com.mercadolibre.lfedele_bootcamp_001.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
