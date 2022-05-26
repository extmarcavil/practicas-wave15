package com.mercadolibre.java_bootcamp_lmaciel_prueba.dtos;

import java.io.Serializable;

/**
 * Sample DTO class.
 */
public class SampleDTO implements Serializable {
  
  private static final long serialVersionUID = 4981959003319466259L;

  private int random;

  /**
   * Creates a new instance.
   */
  public SampleDTO() { }

  /**
   * Creates a new instance, with provided random value.
   *
   * @param random a random number.
   */
  public SampleDTO(int random) {
    this.random = random;
  }

  /**
   * @return random number.
   */
  public int getRandom() {
    return this.random;
  }

  /**
   * @param random a random number.
   * */
  public void setRandom(int random) {
    this.random = random;
  }
}
