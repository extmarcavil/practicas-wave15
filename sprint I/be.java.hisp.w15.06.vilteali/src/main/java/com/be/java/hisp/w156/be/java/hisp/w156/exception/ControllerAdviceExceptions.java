package com.be.java.hisp.w156.be.java.hisp.w156.exception;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponseErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> NotFoundException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DiscountLessThanZeroException.class)
    public ResponseEntity<ResponseErrorDTO> discountLessThanZeroException(DiscountLessThanZeroException ex) {
        return new ResponseEntity<>(ResponseErrorDTO.from(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PriceLessThanZeroException.class)
    public ResponseEntity<ResponseErrorDTO> priceLessThanZeroException(PriceLessThanZeroException ex) {
        return new ResponseEntity<>(ResponseErrorDTO.from(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        return missingRequestParameter(ex);
    }

    public ResponseEntity<Object> missingRequestParameter(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(ResponseErrorDTO.from(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
