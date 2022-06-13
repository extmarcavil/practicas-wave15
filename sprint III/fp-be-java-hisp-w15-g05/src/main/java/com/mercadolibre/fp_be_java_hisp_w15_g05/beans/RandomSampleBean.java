package com.mercadolibre.fp_be_java_hisp_w15_g05.beans;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.SampleDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

  /**
   * @return new instance of SampleDTO.
   */
  public SampleDTO random() {
    return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
  }
}
