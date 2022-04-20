import java.lang.reflect.Array;
import java.util.ArrayList;

public class Localizador {

    private ArrayList<PaqueteTuristico> paquetes;

    public Localizador(){
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(PaqueteTuristico paquete){
        paquetes.add(paquete);
    }

    public ArrayList<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<PaqueteTuristico> paquetes) {
        this.paquetes = paquetes;
    }
}
