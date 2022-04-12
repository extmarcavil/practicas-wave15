package ejercicio2;

import java.util.ArrayList;

public class Curriculum implements Imprimir{

    private String persona;
    ArrayList<String> habilidades = new ArrayList<String>();


    @Override
    public String toString() {
        return "Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(habilidades + " " + persona);
    }
}
