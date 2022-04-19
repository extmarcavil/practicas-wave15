package ejercicioSaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Integer nroCasillero = 0;
    Map<Integer, List<Prenda>> casilleros = new HashMap<>();

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        this.nroCasillero++;
        casilleros.put(nroCasillero, prendas);
        return this.nroCasillero;
    }

    public void mostrarPrendas() {
        casilleros.forEach((key,lista) -> {
            System.out.println("Casillero: " + key);
            lista.forEach(System.out::println);
        } );
    }

    public List<Prenda> devolverPrendas(Integer nroCasillero) {
        return this.casilleros.remove(nroCasillero);
    }


}
