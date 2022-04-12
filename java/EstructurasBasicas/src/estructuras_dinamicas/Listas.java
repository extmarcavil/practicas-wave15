package estructuras_dinamicas;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> compitas = new ArrayList<>();
        compitas.add("Oscar Regino");
        compitas.add("Roy Martinez");
        compitas.add("Matias Alvares");
        compitas.add("Carlos Diaz");
        System.out.println(compitas.size());
        compitas.add("Edwin Gonzales");
        System.out.println("Elemento numero 1 de la lista de compas " + compitas.get(1));

        for (String compa : compitas) {
            System.out.println(compa);
        }
    }
}
