package Ejercicio1;

import java.util.List;

public class Garage {
    private int ID_Garage;
    private List<Vehiculo> vehiculos;


    public int getID_Garage() {
        return ID_Garage;
    }

    public void setID_Garage(int ID_Garage) {
        this.ID_Garage = ID_Garage;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }


    public Garage(int ID_Garage, List<Vehiculo> vehiculos) {
        this.ID_Garage = ID_Garage;
        this.vehiculos = vehiculos;
    }


    public void IncluirVehiculos(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }


    public List<Vehiculo> obtenerVehiculos (){
        return vehiculos;
    }

}
