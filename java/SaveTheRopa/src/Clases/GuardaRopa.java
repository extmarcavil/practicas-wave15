package Clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int id;

    public GuardaRopa() {
        this.id = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(id++, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer id){
        return diccionario.get(id);
    };

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", id=" + id +
                '}';
    }
}
