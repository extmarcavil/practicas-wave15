package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.fp_be_java_hisp_w15_g05.beans.RandomSampleBean;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
