package principal;
import java.util.*;
import principal.*;

public class GuardaRopa {


    // Crear la clase GuardaRopa que contenga como variable un diccionario y un
    // contador que se utilizará como identificador. Las claves del diccionario serán Integer
    // y como valor una lista de prendas.

    private HashMap<Integer, List<Prenda>> guardaRopa; //K=nro de casillero v= ropas guardadas en ese casillero
   // private static Integer identificador = 0;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
        //this.identificador = 0;
    }


    //Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la
    //Clase GuardaRopa, que recibe una lista de prendas y devuelve el número
    //identificador en donde quedaron asignadas las prendas, es decir la clave del
    //diccionario en donde guardamos las prendas.

    public Integer guardarPrendas(int nroCasillero, List<Prenda> listaDePrenda){
        //identificador++;
        System.out.println("Se guarda la prenda con identificador " + nroCasillero);
        guardaRopa.put(nroCasillero, new ArrayList<>(listaDePrenda) );
        return nroCasillero;
    }

    //Crear el método public void mostrarPrendas(), en la Clase GuardaRopa que
    //imprime por pantalla todas las prendas que quedan en el guardarropas junto con el
    //número que les corresponde.

    public void mostrarPrendas(){
        System.out.println();
        System.out.println("---------Prendas Guardadas----------------");

        for(Integer identificador : guardaRopa.keySet()){
            System.out.println("Identificador: "+ identificador);
            System.out.println("Lista de Ropa : ");
            guardaRopa.get(identificador).forEach(System.out::println);
            System.out.println();
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    //Crear el método public List<Prenda> devolverPrendas(Integer numero), en la
    //Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese
    //número.

    public List<Prenda> devolverPrendas(Integer identificador){
        if(guardaRopa.containsKey(identificador)){
            List<Prenda> listaDePrendasDelCliente = guardaRopa.get(identificador);
            guardaRopa.remove(identificador);
            System.out.println("Devolviendo Ropa...");
            return listaDePrendasDelCliente;
        }else{
            return null;
        }


    }

}
