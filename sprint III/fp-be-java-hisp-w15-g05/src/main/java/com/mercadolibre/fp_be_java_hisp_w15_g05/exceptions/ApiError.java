package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

/** 
 * Class containing relevant information from an API call error.
 * */
public class ApiError {

  private String error;

  private String message;

  private Integer status;

  /** 
   * Creates a new instance, with empty fields. 
   */
  public ApiError() { }

  /**
   * Creates a new instance, with provided fields.
   *
   * @param error error short description.
   * @param message full error message.
   * @param status HTTP Status.
   */
  public ApiError(String error, String message, Integer status) {
    this.error = error;
    this.message = message;
    this.status = status;
  }

  /** 
   * @return error short description.
   */
  public String getError() {
    return this.error;
  }

  /** 
   * @param error error short description.
   */
  public void setError(String error) {
    this.error = error;
  }

  /** 
   * @return full error message.
   */
  public String getMessage() {
    return this.message;
  }

  /** 
   * @param message full error message.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /** 
   * @return HTTP Status.
   */
  public Integer getStatus() {
    return this.status;
  }

  /**
   * @param status HTTP Status.
   */
  public void setStatus(Integer status) {
    this.status = status;
  }
}
