package com.vparula.covid;

import com.vparula.covid.entidades.Sintoma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

	public static void main(String[] args) {
		Sintoma s1= new Sintoma(1,"Nombre1","GRAVE");
		Sintoma s2= new Sintoma(2,"Nombre2","NO TAN GRAVE");
		Sintoma s3= new Sintoma(3,"Nombre3","MENOS GRAVE");
		Sintoma s4= new Sintoma(4,"Nombre4","LEVE");


		SpringApplication.run(CovidApplication.class, args);
	}

}
