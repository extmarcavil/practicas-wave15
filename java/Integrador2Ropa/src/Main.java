import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Prenda campera = new Prenda("Adidas", "Campera cuero");
        Prenda zapatillas = new Prenda("Nike", "Zapatillas deportivas");
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> ropa = new ArrayList<>();
        ropa.add(campera);
        ropa.add(zapatillas);

        Integer id = guardaRopa.guardarPrendas(ropa);

        List<Prenda> devolverCampera = guardaRopa.devolverPrendas(1);
        System.out.println(devolverCampera);
        List<Prenda> devolverZapas = guardaRopa.devolverPrendas(2);
        System.out.println(devolverZapas);

        //String mostrar = guardaRopa.mostrarPrendas();

    }
}
