import java.util.*;

public class GuardaRopa {
    private static int contador;
    private int id;
    private Map<Integer, List> diccionario;

    public GuardaRopa() {
        this.id = ++this.contador;
        this.diccionario = new HashMap<>();
    }

    public int getId() {
        return this.id;
    }

    public Map<Integer, List> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrenda(List<Prenda> listaPrendas){
        Integer id = this.getId();
        diccionario.put(id,listaPrendas);
        return id;
    }

    public void mostrarPrendas(){
        for ( Map.Entry<Integer, List> entry : diccionario.entrySet()) {
            Integer key = entry.getKey();
            List<Prenda> tab = entry.getValue();
                for(Prenda prenda : tab){
                    System.out.println("Id de la prenda: " + key + " - Esta es la prenda de Marca : " + prenda.getMarca() + ", y posee el modelo: " + prenda.getModelo());
                }
        }
    }

    public List<Prenda> devolverPrendas(){

    }
}
