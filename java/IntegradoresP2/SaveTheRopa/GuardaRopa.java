package IntegradoresP2.SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id = 0;
    private HashMap<Integer, List<Prenda>> prendas = new HashMap<>();

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        id += 1;
        prendas.put(id, listaDePrendas);
        System.out.println("Prendas guardadas. Identificador nro: " + id);
        System.out.println();
        return id;
    }

    public void mostrarPrendas() {
        if (prendas.size() == 0){
            System.out.println("Guardaropas vacío.");
        } else {
            for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
                System.out.println("Identificador: " + entry.getKey() + "\nLista de Prendas:");
                entry.getValue().stream().forEach(System.out::println);
                System.out.println();
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaPrendas = null;
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()){
            if (numero.equals(entry.getKey())) {
                listaPrendas = entry.getValue();
                System.out.println("Prendas a devolver:");
                entry.getValue().stream().forEach(System.out::println);
                System.out.println();
                prendas.remove(entry.getKey());
            }
        }
        return listaPrendas;
    }
}
