import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    Map<Integer, Prenda> diccionario = new HashMap<>();
    Integer contador = 0;

    public GuardaRopa() {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        for(Prenda p : listaDePrenda){
            contador+=1;
            diccionario.put(contador,p);
        }
        return contador;
    }

    public String mostrarPrendas(){
        for(Map.Entry<Integer, Prenda> elem : diccionario.entrySet()){
            Integer k = elem.getKey();
            Prenda v = elem.getValue();
            System.out.println( v + ", id:" + k);
        }
        return "";
    }

    public List<Prenda> devolverPrendas(Integer numero){
         Prenda p = diccionario.get(numero);
        List<Prenda> devolverPrenda = new ArrayList<>();
        devolverPrenda.add(p);
        return devolverPrenda;
    }

    public Map<Integer, Prenda> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, Prenda> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
