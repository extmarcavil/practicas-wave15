package ar.com.alehenestroza;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> listaDePrendas;
    private int contador;

    public GuardaRopa() {
        listaDePrendas = new HashMap<>();
        contador = 0;
    }

    public Map<Integer, List<Prenda>> getListaDePrendas() {
        return listaDePrendas;
    }

    public void setListaDePrendas(Map<Integer, List<Prenda>> listaDePrendas) {
        this.listaDePrendas = listaDePrendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        contador++;
        this.listaDePrendas.put(contador, listaDePrendas);

        return contador;
    }

    public void mostrarPrendas() {
        this.listaDePrendas.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("Numero " + entry.getKey() + ":");
                    entry.getValue().stream()
                            .forEach(System.out::println);
                    }
                );
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return listaDePrendas.get(numero);
    }
}
