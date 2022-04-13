package saveTheRopa.modelo;

import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> map;
    private Integer contador;

    public GuardaRopa() {
        contador=0;
    }

    public Integer guardarPrendas(List<Prenda> listDePrendas){
        contador++;
        map.put(contador,listDePrendas);
        return contador;
    }

}
