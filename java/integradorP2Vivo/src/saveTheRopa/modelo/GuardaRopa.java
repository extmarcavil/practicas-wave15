package saveTheRopa.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> map;
    private Integer contador;

    public GuardaRopa() {
        contador=0;
        map=new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listDePrendas){
        contador++;
        map.put(contador,listDePrendas);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println("=======================================");
        System.out.println("Prendas almacenadas en el GuardaRopas: ");
        System.out.println(map);
        System.out.println("=======================================");
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> list= map.remove(numero);
        if (list == null) System.out.println("No pudimos localizar sus prendas :(");
        else System.out.println("Prendas devueltas con exito.");
        return list;
    }

}
