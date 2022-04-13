package ClasesAbstractasEInterfaces.Ej2;

import ClasesAbstractasEInterfaces.Ej2.Clases.Curriculum;
import ClasesAbstractasEInterfaces.Ej2.Clases.Informe;
import ClasesAbstractasEInterfaces.Ej2.Clases.Libro;
import ClasesAbstractasEInterfaces.Ej2.Interfaces.Informacion;

import java.util.ArrayList;

public class Main  implements Informacion {

    public static void main(String[] args) {

        Main main = new Main();

        ArrayList<String> lista = new ArrayList<>();
        lista.add("C#");
        lista.add("Java");
        lista.add("Python");
        Curriculum curriculum = new Curriculum("Gonzalo", "Sinnott", "gonzalo.sinnott@gmail.com", lista);

        Libro libro = new Libro("C#", "Microsoft", "Programming", 200);

        Informe informe = new Informe("Pedro", "Pablo", "Informe de Errores", 5);

        main.imprimirArchivo(curriculum);
        main.imprimirArchivo(libro);
        main.imprimirArchivo(informe);
    }


    @Override
    public void imprimirArchivo(Object obj) {
        System.out.println(obj);
    }
}
