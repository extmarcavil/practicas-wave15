package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    private int id;
    private static int idSig = 1;
    private List <Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
        id = idSig;
        idSig++;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
