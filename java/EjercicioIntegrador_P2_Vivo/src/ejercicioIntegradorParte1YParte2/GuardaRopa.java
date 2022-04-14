package ejercicioIntegradorParte1YParte2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int contador;
    Map<Integer, List <Prenda>> listaPrendas = new HashMap<>();

    public GuardaRopa() {
        contador=0;
    }

   public Integer guardarPrendas(List<Prenda> prendas){
        contador++;
        listaPrendas.put(contador,prendas);
        return  contador;
   }

   public void mostarPrendas(){
//      for (int i = 1 ; i< listaPrendas.size();i++){
//          System.out.println(i +" - "+ listaPrendas.get(i));
//       }
       for (Map.Entry<Integer,List<Prenda>> p: listaPrendas.entrySet()) {
           System.out.println(p.getKey()+"-" + p.getValue());
       }
   }

   public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> listaN = listaPrendas.get(numero);
        listaPrendas.remove(numero);
        return listaN;
   }


}
