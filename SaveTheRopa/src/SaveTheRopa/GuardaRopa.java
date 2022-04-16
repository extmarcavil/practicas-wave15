package SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;


    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer key = contador;
        diccionario.put(key, listaDePrenda);
        contador++;
        return key;
    }

    public void mostrarPrendas() {
        for (Integer key : diccionario.keySet()) {
            diccionario.forEach((k,v) -> System.out.println("Codigo: " + k + " Prendas: " + v));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> listaPrendas = diccionario.get(numero);
        if (listaPrendas != null){
            diccionario.remove(numero);
        }
        else{
            System.out.println("No se encontró la prenda");
        }
        return listaPrendas;
    }
}
