package ejercicioSaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int idGuardaRopa;
    private HashMap<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.idGuardaRopa = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int id = this.idGuardaRopa + 1;
        setIdGuardaRopa(id);
        this.prendas.put(this.idGuardaRopa, listaDePrenda);

        return idGuardaRopa;
    }

    public void mostrarPrendas(){
        for(Map.Entry listaPrendas : this.prendas.entrySet()){
            System.out.println("Identificador de prendas: " + listaPrendas.getKey());
            System.out.println("Prendas: ");
            System.out.println(listaPrendas.getValue());
            /*for(Prenda p : (List<Prenda>)listaPrendas.getValue()){
                System.out.println(p);
            }*/
        }
    }

    //Otra forma de recorrer la lista de prendas
    public void mostrarPrendas2(){
        this.prendas.keySet().forEach(k -> {
                    System.out.println("Identificador de prendas: " + k);
                    this.prendas.get(k).forEach(System.out::println);
                }
        );
    }

    public List<Prenda> devolverPrenda(Integer nro){
        return this.prendas.get(nro);
    }

    public int getIdGuardaRopa() {
        return idGuardaRopa;
    }

    public void setIdGuardaRopa(int idGuardaRopa) {
        this.idGuardaRopa = idGuardaRopa;
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "idGuardaRopa=" + idGuardaRopa +
                ", prendas=" + prendas +
                '}';
    }
}
