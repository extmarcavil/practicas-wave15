import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> map;
    private Integer contador;

    public GuardaRopa() {
        contador = 0;
        map = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listPrendas){
        contador++;
        map.put(contador,listPrendas);
        return  contador;
    }

    public  void mostrarPrenda(){
        System.out.println(map);
    }

    public  List<Prenda> devolverPrendas(Integer Id){
         return map.remove(Id);
    }

}
