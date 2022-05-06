package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentRequestException extends MethodArgumentNotValidException {

	public InvalidArgumentRequestException(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
		// TODO Auto-generated constructor stub
	}
}