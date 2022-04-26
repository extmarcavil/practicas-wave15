package entitiy;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private int index = 0;
    private HashMap<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int aux = index;
        guardaRopa.put(index++,listaDePrenda);

        return aux;
    }

    public void mostrarPrendas(){
        System.out.println("________");
        guardaRopa.forEach((index,list) ->{
            System.out.println("Mostrando prendas con el ticket " + index);
            list.forEach(System.out::println);
        });
        System.out.println("________");
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> toRet =  guardaRopa.get(numero);

        return toRet;
    }
}
