package Integrador2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa() {
        prendas = new HashMap<>();
        contador = Integer.valueOf(0);
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contador += 1;
        prendas.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas(){
        for (Integer i : prendas.keySet()){
            System.out.println("\tNúmero identificador: " + i.intValue());
            prendas.get(i).stream().forEach(System.out::println);
            System.out.println();
        }
        if (prendas.keySet().size() == 0){
            System.out.println("GuardaRopa vacío");
        }
    }

    public List<Prenda> devolverPrenda(Integer numero){
        if (prendas.containsKey(numero)){
            List<Prenda> lista = prendas.get(numero);
            prendas.remove(numero);
            return lista;
        } else {
            System.out.println("Clave no encontrada");
            return null;
        }
    }

}
