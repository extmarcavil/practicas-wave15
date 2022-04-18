package SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer codigo=0;
    private HashMap<Integer,List<Prenda>> diccionario;

    public GuardaRopa() {
        diccionario= new HashMap<>();
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        diccionario.put(codigo,listaPrendas);
        codigo++;
        return codigo-1;
    }
    public void mostrarPrendas(){
        diccionario.forEach((k,v) -> System.out.println("Codigo: " + k + ": Prenda: " + v.toString()));
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }
}
