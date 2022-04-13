import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    HashMap<Integer, List<Prenda>> deposito = new HashMap<Integer, List<Prenda>>();
    private int contador;

    public GuardaRopa(Map<Integer, List<Prenda>> deposito, int contador) {
        this.deposito = (HashMap<Integer, List<Prenda>>) deposito;
        this.contador = contador;
    }

    public GuardaRopa() {

    }

    public HashMap<Integer, List<Prenda>> getDeposito() {
        return deposito;
    }

    public void setDeposito(HashMap<Integer, List<Prenda>> deposito) {
        this.deposito = deposito;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        deposito.put(contador,listaPrendas);
        contador++;
        return contador-1;
    }
    public void mostrarPrendas(){
        deposito.forEach((p,k) -> System.out.println(p + " " + k));
    }
    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listaPrendas = deposito.get(numero);
        deposito.remove(numero);
        return listaPrendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "deposito=" + deposito +
                ", contador=" + contador +
                '}';
    }
}
