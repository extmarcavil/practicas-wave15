package SaveRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> deposito;
    private Integer contador;


    public GuardaRopa() {
        this.deposito = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {

        deposito.put(contador, listaDePrendas);
        contador++;
        return contador-1;
    }

    public void mostrarPrendas() {
        String prendas = "";
        System.out.println("Lista de Prendas");

        for (Map.Entry<Integer, List<Prenda>> entry : deposito.entrySet()) {
            for (Prenda prenda : entry.getValue()) {
                prendas += prenda.getModelo() + " " + prenda.getMarca() + ", ";
            }
            System.out.println("#" + entry.getKey() + " tiene " + prendas);
            prendas = "";
        }

    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas;

        if (deposito.containsKey(numero)) {
            prendas = deposito.get(numero);
            deposito.remove(numero);
        } else {
            prendas = null;
        }

        return prendas;
    }



}
