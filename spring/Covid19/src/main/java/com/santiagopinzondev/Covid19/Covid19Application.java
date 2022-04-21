package com.santiagopinzondev.Covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		Sintoma fiebre = new Sintoma("fiebre", "fiebre", 4);
		Sintoma cansancio = new Sintoma("cansancio", "Cansancio", 10);
		Sintomas sintomas = new Sintomas();
		sintomas.addSintoma(fiebre);
		sintomas.addSintoma(cansancio);

		Persona santiago = new Persona(0, "santiago", "pinzon", 19);
		Persona maria = new Persona(1, "Maria", "Perez", 62);

		PersonaSintomaDTO santiagoDTO = new PersonaSintomaDTO();
		santiagoDTO.setNombre(santiago.getNombre());
		santiagoDTO.setApellido(santiago.getApellido());
		santiagoDTO.setEdad(santiago.getEdad());
		santiagoDTO.setSintoma(fiebre);

		PersonaSintomaDTO mariaDTO = new PersonaSintomaDTO();
		mariaDTO.setNombre(maria.getNombre());
		mariaDTO.setApellido(maria.getApellido());
		mariaDTO.setEdad(maria.getEdad());
		mariaDTO.setSintoma(cansancio);

		PersonasDTO.addPersona(santiagoDTO);
		PersonasDTO.addPersona(mariaDTO);


		SpringApplication.run(Covid19Application.class, args);
	}

}
