package ar.com.alehenestroza.nosqlempleados.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDTO {
    private String  id;
    private String  name;
    private String  lastName;
    private String  state;
    private String  city;
    private Integer age;
}
