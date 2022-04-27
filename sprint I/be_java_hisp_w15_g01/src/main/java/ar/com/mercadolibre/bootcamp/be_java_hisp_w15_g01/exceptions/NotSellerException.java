package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User is not selled")
public class NotSellerException extends RuntimeException {

}
