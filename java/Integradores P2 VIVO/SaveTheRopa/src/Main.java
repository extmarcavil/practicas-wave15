import java.util.List;

public class Main {
    public static void main(String[] args) {
        var guardaRopa = new GuardaRopa();
        var listPrenda = List.of(new Prenda("Adidas","Gorra"),new Prenda("Nike","Pants"));
        guardaRopa.guardarPrendas(listPrenda);
        guardaRopa.mostrarPrenda();

        System.out.println(guardaRopa.devolverPrendas(1));

        guardaRopa.mostrarPrenda();
        System.out.println(guardaRopa.devolverPrendas(20));
    }
}
