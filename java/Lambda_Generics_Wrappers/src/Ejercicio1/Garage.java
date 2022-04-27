package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private int id;
    private int identificador_unico;
    private List<Vehiculo>vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificador_unico() {
        return identificador_unico;
    }

    public void setIdentificador_unico(int identificador_unico) {
        this.identificador_unico = identificador_unico;
    }


    public  void incluirVehiculos (Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    //Agregar el tipo de objeto Vehiculo. Infiere automaticamente cuando esta vacio que es un OBject y Vehiculo es tipo de Objet.
    public List<Vehiculo> obtenerVehiculos (){
        return vehiculos;
    }


}
