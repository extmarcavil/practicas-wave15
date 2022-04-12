import java.util.ArrayList;

public class Garaje {

    //region Atributos
    private static int contador = 0;
    private int Id;
    private ArrayList<Vehiculo> ListaVehiculos;
    //endregion

    //region Constructor

    public Garaje(ArrayList<Vehiculo> listaVehiculos) {
        incrementarContador();
        Id = obtenerContador();
        ListaVehiculos = listaVehiculos;
    }

    //endregion

    //region Getters Setters

    public int getId() {
        return Id;
    }

    public void setId() {
        Id = obtenerContador();
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return ListaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        ListaVehiculos = listaVehiculos;
    }

    //endregion

    //region Privados
    private static void incrementarContador() {
        contador++;
    }
    private static int obtenerContador() {
        return contador;
    }
    //endregion
}
