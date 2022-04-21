package ar.com.mercadolibre.bootcamp.lfedele.covid19.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {
    private static Long nextId = 1L;

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;

    @Setter(value = AccessLevel.NONE)
    private List<Sintoma> sintomas = new ArrayList<>();

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = Persona.nextId;
        Persona.nextId++;
    }

    public void addSintoma(Sintoma sintoma) {
        this.sintomas.add(sintoma);
    }

    public void removeSintoma(Sintoma sintoma) {
        this.sintomas.remove(sintoma);
    }

    public Boolean isRiskPerson() {
        return this.getEdad() >= 60 && this.getSintomas().size() > 0;
    }
}
