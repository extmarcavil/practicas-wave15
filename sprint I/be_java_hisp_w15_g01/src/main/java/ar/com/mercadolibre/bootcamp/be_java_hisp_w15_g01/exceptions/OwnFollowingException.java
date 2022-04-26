package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Your cant follow yourself")
public class OwnFollowingException extends  RuntimeException {
}
