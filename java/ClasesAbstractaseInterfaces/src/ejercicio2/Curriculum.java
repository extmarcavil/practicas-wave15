package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    String nombre;
    int edad;
    List<String> habilidades = new ArrayList<>();


    @Override
    public void imprimir() {
        System.out.println("Soy Juan Perez, tengo 20 anios y tengo las siguientes habilidades ");
        for (String h: habilidades){
            System.out.println(h);
        }

    }
}
