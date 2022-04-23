package ejerpracticosp2vivo.calculadora.calculadoradecalorias;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculadoraDeCaloriasApplication {

    @Bean
    ModelMapper getMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraDeCaloriasApplication.class, args);
    }

}
