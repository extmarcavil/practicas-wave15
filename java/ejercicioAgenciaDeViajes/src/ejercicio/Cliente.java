package ejercicio;

import java.util.ArrayList;

public class Cliente {
    String nombre;
    ArrayList<Paquete> listaDePaquetes;

    public Cliente(String nombre) {
        this.nombre = nombre;
        listaDePaquetes = new ArrayList<>();
    }

    public void guardarPaquete(Paquete paquete) {
        listaDePaquetes.add(paquete);
    }
}
