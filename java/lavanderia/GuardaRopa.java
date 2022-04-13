package lavanderia;

import java.util.*;

public class GuardaRopa {

    private int contador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        this.prendas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        prendas.entrySet().forEach(System.out::println);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return Optional.ofNullable(prendas.get(numero))
                .orElse(Collections.emptyList());
    }


}
