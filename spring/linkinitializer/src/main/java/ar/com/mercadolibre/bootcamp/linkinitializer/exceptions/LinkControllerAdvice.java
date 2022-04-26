package ar.com.mercadolibre.bootcamp.linkinitializer.exceptions;

import ar.com.mercadolibre.bootcamp.linkinitializer.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Para tener un ejemplo de diferentes formas de exceptions
@ControllerAdvice
public class LinkControllerAdvice {
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ResponseDTO> handleWrongPasswordException(WrongPasswordException e) {
        ResponseDTO dto = new ResponseDTO();
        dto.setSuccess(false);
        dto.setMessage(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(dto);
    }
}
