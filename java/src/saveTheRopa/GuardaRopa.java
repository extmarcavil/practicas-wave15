package saveTheRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int index = 0;
    private HashMap<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        int aux = index;
        this.guardaRopa.put(index,listaPrendas);
        //System.out.println("Nro de identificador: " + index);
        index++;
        return aux;
    }

    public void mostrarPrendas(){
        System.out.println(" ---- ");
        guardaRopa.forEach((index,list) ->{
            System.out.println(" -- ");
            System.out.println("Mostrando prendas con el Ticket " + index + ": ");
            list.forEach(System.out::println);
            System.out.println(" -- ");
        });
        System.out.println(" ---- ");
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> toRet = guardaRopa.get(numero);
        return toRet;
    }
}
