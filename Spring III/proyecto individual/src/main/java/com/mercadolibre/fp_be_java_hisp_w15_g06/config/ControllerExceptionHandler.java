package com.mercadolibre.fp_be_java_hisp_w15_g06.config;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ErrorDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.*;
import com.newrelic.api.agent.NewRelic;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Basic handling for exceptions.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  /**
   * Handler for not found routes.
   * 
   * @param req the incoming request.
   * @param ex the exception thrown when route is not found.
   * @return {@link ResponseEntity} with 404 status code and the route that was not found in the body.
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ApiError> noHandlerFoundException(
      HttpServletRequest req, NoHandlerFoundException ex) {
    ApiError apiError =
        new ApiError(
            "route_not_found",
            String.format("Route %s not found", req.getRequestURI()),
            HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  /**
   * Handler for external API exceptions.
   *  
   * @param e the exception thrown during a request to external API.
   * @return {@link ResponseEntity} with status code and description provided for the handled exception.
   */
  @ExceptionHandler(ApiException.class)
  protected ResponseEntity<ApiError> handleApiException(ApiException e) {
    Integer statusCode = e.getStatusCode();
    boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode;
    NewRelic.noticeError(e, expected);
    if (expected) {
      LOGGER.warn("Internal Api warn. Status Code: " + statusCode, e);
    } else {
      LOGGER.error("Internal Api error. Status Code: " + statusCode, e);
    }

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  /**
   * Handler for internal exceptions.
   * 
   * @param e the exception thrown during request processing.
   * @return {@link ResponseEntity} with 500 status code and description indicating an internal error.
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
    LOGGER.error("Internal error", e);
    NewRelic.noticeError(e);

    ApiError apiError =
        new ApiError(
            "internal_error", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(value = {InvalidProductException.class})
  protected ResponseEntity<ErrorDTO> InvalidProductException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidProductException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {InvalidWarehouseException.class})
  protected ResponseEntity<ErrorDTO> InvalidWarehouseException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidWarehouseException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {AgentDoesNotBelongToWarehouseException.class})
  protected ResponseEntity<ErrorDTO> AgentDoesNotBelongToWarehouseException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("AgentDoesNotBelongToWarehouseException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {InvalidSectionException.class})
  protected ResponseEntity<ErrorDTO> InvalidSectionException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidSectionException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {QuantityNotAvailableException.class})
  protected ResponseEntity<ErrorDTO> QuantityNotAvailableException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("QuantityNotAvailableException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BatchMinTempBiggerThanCurrentTempException.class})
  protected ResponseEntity<ErrorDTO> BatchMinTempBiggerThanCurrentTempException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("BatchMinTempBiggerThanCurrentTempException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BatchTempOutsideSectionTempRangeException.class})
  protected ResponseEntity<ErrorDTO> BatchTempOutsideSectionTempRangeException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("BatchTempOutsideSectionTempRangeException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {InvalidInboundOrderException.class})
  protected ResponseEntity<ErrorDTO> InvalidInboundOrderException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidInboundOrderException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {InvalidBatchException.class})
  protected ResponseEntity<ErrorDTO> InvalidBatchException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidBatchException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BatchCurrentQuantityBiggerThanInitialQuantityException.class})
  protected ResponseEntity<ErrorDTO> BatchCurrentQuantityBiggerThanInitialQuantityException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("BatchCurrentQuantityBiggerThanInitialQuantityException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BatchCurrentQuantityIsDifferentFromInitialQuantityException.class})
  protected ResponseEntity<ErrorDTO> BatchCurrentQuantityIsDifferentFromInitialQuantityException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("BatchCurrentQuantityIsDifferentFromInitialQuantityException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {ProductNotFoundInAnyWarehouseException.class})
  protected ResponseEntity<ErrorDTO> ProductNotFoundInAnyWarehouseException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("ProductNotFoundInAnyWarehouseException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {ProductNotFoundException.class})
  protected ResponseEntity<ErrorDTO> ProductNotFoundException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("ProductNotFoundException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {ProductCategoryIsDifferentFromSectionCategoryException.class})
  protected ResponseEntity<ErrorDTO> ProductCategoryIsDifferentFromSectionCategoryException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("ProductCategoryIsDifferentFromSectionCategoryException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {InvalidOrderException.class})
  protected ResponseEntity<ErrorDTO> InvalidOrderException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidOrderException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BatchNotFoundException.class})
  protected ResponseEntity<ErrorDTO> BatchNotFoundException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("BatchNotFoundException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {ProductsNotFoundException.class})
  protected ResponseEntity<ErrorDTO> ProductsNotFoundException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("ProductsNotFoundException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {InvalidSectionbatchException.class})
  protected ResponseEntity<ErrorDTO> InvalidSectionbatchException(RuntimeException ex){
    ErrorDTO errorDTO = new ErrorDTO("InvalidSectionbatchException", ex.getMessage());
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }
}
