import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuardaRopa {

    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    /**
     * Contructor donde inicializamos el contador en 0
     * y el diccionario vacio.
     */
    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<>();

    }

    /**
     * Recibe una lista de prendas y las almacena en el diccionario
     * utilizando el contador como KEY para las mismas.
     * @param prendasAGuardar
     * @return
     */
    public Integer guardarPrendas(List<Prenda> prendasAGuardar){

        Integer key = contador;
        diccionario.put(key,prendasAGuardar);
        contador++;
        return key;
    }

    /**
     * Devuelve la lista de prendas del diccionario. Y Elimina la key
     * @param numero
     * @return
     */
    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> prendas = diccionario.remove(numero);
        return prendas;
    }


    /**
     * Imprime todas las prendas del diccionario
     */
    public void mostrarPrendas(){
        for (Integer key: diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(key);
            System.out.println(listaDePrendas);
        }
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }
}
