package AbstractasInterfaces.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<>();
        Persona persona = new Persona("Nico", "Santos");
        Curriculum curriculum = new Curriculum(persona);

        LibroPDF pdf = new LibroPDF(1, "Nico", "Java", "Accion");
        Informe informe = new Informe("texto", 2, "Nico", "Nico");

        habilidades.add("ingles");
        habilidades.add("español");
        curriculum.setHabilidades(habilidades);

        Documento.imprimir(curriculum);
        Documento.imprimir(pdf);
        Documento.imprimir(informe);

    }
}
