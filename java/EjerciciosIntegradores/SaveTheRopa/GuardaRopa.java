package EjerciciosIntegradores.SaveTheRopa;

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

    public Integer guardarPrendas(List<Prenda> prendas) {
        Integer key = contador;
        diccionario.put(contador,prendas);
        contador++;
        return key;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()){
            System.out.println("Ticket: " + entry.getKey() +  " " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendas = diccionario.remove(numero);
        return prendas;
    }
}



