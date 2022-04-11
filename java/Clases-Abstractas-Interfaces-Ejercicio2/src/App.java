import interfaces.ImprimibleImpl;
import model.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ImprimibleImpl imprimible = new ImprimibleImpl();
        Documento d;

        Persona p = new Persona("11111111", "Tomas", 23);
        List<Habilidad> habilidades = List.of(new Habilidad("Desarrollador"), new Habilidad("Tester"));
        d = new CV(p, habilidades);
        imprimible.imprimir(d);

        System.out.println("------------");

        d = new LibroPDF(100, "Tomas Ravelli", "Un titulo", "Un genero");
        imprimible.imprimir(d);

        System.out.println("------------");

        d = new Informes("Texto del informe muy largo", 1, "Tomas Ravelli", "Tomas Ravelli");
        imprimible.imprimir(d);
    }
}
