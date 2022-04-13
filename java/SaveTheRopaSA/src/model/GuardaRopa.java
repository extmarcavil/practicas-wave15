package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> guardaRopas;
    private Integer lastIndex;

    public GuardaRopa(){
        guardaRopas = new HashMap<>();
        lastIndex = 0;
    }

    public HashMap<Integer, List<Prenda>> getGuardaRopas() {
        return guardaRopas;
    }

    public void setGuardaRopas(HashMap<Integer, List<Prenda>> guardaRopas) {
        this.guardaRopas = guardaRopas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "guardaRopas=" + guardaRopas +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
         lastIndex++;
         guardaRopas.put(lastIndex, listaDePrenda);
         return lastIndex;
    }

    public void mostrarPrendas(){
        guardaRopas.forEach((clave, valor) -> System.out.println("Numero: " + clave + " --- Ropa: " + valor));
    }

    public List<Prenda> devolverPrendas(Integer index){
        return guardaRopas.get(index);
    }
}
