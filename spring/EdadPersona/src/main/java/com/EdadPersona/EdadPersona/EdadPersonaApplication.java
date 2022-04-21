package com.EdadPersona.EdadPersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class EdadPersonaApplication {

	/*Ejercicio 1: Obteniendo la edad de una persona
	Se necesita desarrollar un API que recibe como parámetro tres valores:
	Día
	Mes
	Año

	Dichos valores corresponden a la fecha de nacimiento de una persona y deben ser valores enteros. Por ejemplo, un ingreso válido sería: 10/01/1990.
	Para este caso, es necesario que la fecha de nacimiento se pase mediante la URL del navegador. Por ejemplo: http://localhost:8080/10/01/1990. Como resultado, la API deberá devolver la edad de la persona.
	En el navegador se debería ver algo similar:

	31

	Realizar los pasos necesarios para implementar un método en el controlador que mapee correctamente el path ingresado y que devuelva la información requerida.
*/
	public static void main(String[] args) {
		SpringApplication.run(EdadPersonaApplication.class, args);
	}

}
