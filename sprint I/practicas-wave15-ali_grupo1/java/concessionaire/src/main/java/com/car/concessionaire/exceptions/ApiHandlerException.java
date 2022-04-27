package com.car.concessionaire.exceptions;

import com.car.concessionaire.dto.BadRequestDto;
import com.car.concessionaire.dto.FieldErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<FieldErrorDto> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(FieldErrorDto.from(ex), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        return missingRequestParameterException(ex);
    }

    public ResponseEntity<Object> missingRequestParameterException(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(FieldErrorDto.from(ex), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return methodArgumentNotValidException(ex);
    }

    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldErrorDto> fieldErrors = exception.getFieldErrors().stream()
                .map(this::createFieldError)
                .collect(Collectors.toList());

        return new ResponseEntity<>(BadRequestDto.from(
                "Validation failed for argument",
                fieldErrors),
                HttpStatus.BAD_REQUEST);
    }

    private FieldErrorDto createFieldError(FieldError err) {
        return new FieldErrorDto(err.getField(), err.getDefaultMessage());
    }
}
