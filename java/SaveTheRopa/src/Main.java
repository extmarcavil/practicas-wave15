import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("SAVE THE ROPA!");

        GuardaRopa unGuardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda("ADIDAS", "UltraBoost");
        List<Prenda> prendasEdu = Arrays.asList(prenda,
                new Prenda("ADIDAS", "Messi"),
                new Prenda("Nike", "CR7"),
                new Prenda("Puma", "Bolt"));

        Integer keyPrendaGuardada = unGuardaRopa.guardarPrendas(prendasEdu);

        unGuardaRopa.mostrarPrendas();

        List<Prenda> prendas = unGuardaRopa.devolverPrendas(keyPrendaGuardada);

        unGuardaRopa.mostrarPrendas();

        System.out.println(unGuardaRopa.getDiccionario());
    }
}
