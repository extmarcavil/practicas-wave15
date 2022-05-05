import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    private Map<Integer, List<Prenda>> deposito;
    private int contador;

    public Guardarropa() {
        this.deposito  = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        deposito.put(contador, listaDePrenda);
        contador++;
        return contador-1;
    }

    public void mostrarPrendas() {
        deposito.forEach((k,v) -> System.out.println("Ticket: " + k + " - Prendas: " + v));

        /*
        Otra opcion
        for (Map.Entry<Integer, List<Prenda>> entry : deposito.entrySet()) {
            System.out.println(entry.getValue());
        }
        */
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = deposito.get(numero);

        if (prendas != null)
            deposito.remove(numero);
        else
            System.out.println("No existe esa prenda");

        return prendas;
    }
}
