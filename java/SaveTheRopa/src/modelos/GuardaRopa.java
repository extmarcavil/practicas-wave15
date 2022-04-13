package modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> pertenencias;
    private Integer contador;

    public GuardaRopa() {
        pertenencias = new HashMap<>();
        contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        pertenencias.put(contador, listaDePrendas);
        return contador++;
    }

    public void mostrarPrendas() {
        System.out.println("--- Prendas en el guarda ropa ---");
        for (Integer clave : pertenencias.keySet()) {
            for (Prenda p : pertenencias.get(clave)) {
                System.out.println("Numero: " + clave);
                System.out.println("\tp");
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return pertenencias.remove(numero);
    }
}
