package saveTheRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    // Variables
    private HashMap<Integer, List> obj;
    private Integer contador;
    private List<Prenda> listaPrendas;
    private Integer identificadorGuardaRopa;

    // Constructor
    public GuardaRopa(Integer identificadorGuardaRopa) {
        this.contador = 0;
        this.identificadorGuardaRopa = identificadorGuardaRopa;
        this.obj = new HashMap<Integer, List>();
    }

    // Setters and Getters
    public HashMap<Integer, List> getObj() {
        return obj;
    }

    public void setObj(HashMap<Integer, List> obj) {
        this.obj = obj;
    }

    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    // Metodos
    public void agregarPrenda(Prenda prenda) {
        this.listaPrendas.add(prenda);
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        obj.put(this.contador, listaDePrendas);
        this.contador += 1;
        return this.contador;
    }

    /*public void devolverPrendas(int id) {
        List<Prenda> alfa = new ArrayList<Prenda>(obj.get(id - 1));;
        String prendasGuardadas = "";
        for (int i = 0; i<alfa.size(); i++) {
            prendasGuardadas += "La prenda " + (i+1) + " es el modelo " + alfa.get(i).getModelo() + " de marca " + alfa.get(i).getMarca() + ". ";
        }
        System.out.println(prendasGuardadas);
    }*/

    public void devolverPrendas(int id) {
        System.out.println(obj.keySet());
    }

    public void mostrarPrendas() {

    }
}