package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The post does not exists")
public class PostNotFoundException extends RuntimeException {
}
