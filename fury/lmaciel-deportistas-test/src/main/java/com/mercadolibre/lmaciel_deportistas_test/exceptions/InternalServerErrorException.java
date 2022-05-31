package com.mercadolibre.lmaciel_deportistas_test.exceptions;

import org.springframework.http.HttpStatus;

/** 
 * Exception containing relevant information for internal API errors.
 */
public class InternalServerErrorException extends ApiException {

  private static final long serialVersionUID = -525546673970530803L;

  private static final String INTERNAL_ERROR_CODE = "internal_error";

  /**
   * Creates a new instance, with provided cause.
   *
   * @param e cause
   */
  public InternalServerErrorException(Throwable e) {
    super(
        INTERNAL_ERROR_CODE,
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        e);
  }

  /**
   * Creates a new instance, with provided cause and custom message.
   *
   * @param message custom message.
   * @param e cause.
   */
  public InternalServerErrorException(String message, Throwable e) {
    super(INTERNAL_ERROR_CODE, message, HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
  }
}
