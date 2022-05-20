package ar.com.alehenestroza.nosqlempleados.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewEmpleadoDTO {
    private String  name;
    private String  lastName;
    private String  state;
    private String  city;
    private Integer age;
}
