package ar.com.alehenestroza.nosqlempleados.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private String  id;
    private String  name;
    private String  lastName;
    private String  state;
    private String  city;
    private Integer age;
}
