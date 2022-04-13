import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike", "zapatillas");
        Prenda prenda2 = new Prenda("Addidas", "remera");

        Guardarropa guardarropa = new Guardarropa();

        int ticket = guardarropa.guardarPrendas(List.of(prenda1, prenda2));

        guardarropa.mostrarPrendas();

        System.out.println("Las prendas obtenidas son: " + guardarropa.devolverPrendas(ticket));
    }
}
