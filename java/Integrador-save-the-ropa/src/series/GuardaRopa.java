package series;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    Map<Integer, List<Prenda>> locker;

    public GuardaRopa() {
        this.contador = 0;
        locker = new HashMap<>();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.locker.put(this.contador, listaDePrenda);
        int contador = this.getContador();
        this.setContador(this.getContador() + 1);
        return contador;
    }

    public void mostrarPrendas(){
        this.locker.forEach((contador, prenda) ->{
            System.out.println("Clave: " + contador + " " + prenda.toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer clave){
        return this.locker.get(clave);
    }
}
