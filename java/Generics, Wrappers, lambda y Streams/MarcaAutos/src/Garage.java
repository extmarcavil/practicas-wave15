import java.util.ArrayList;

public class Garage {
    private static int contador;
    private int idGarage;
    private ArrayList<Automovil> listaAutomoviles;

    public Garage(ArrayList<Automovil> listaAutomoviles) {
        this.idGarage = ++this.contador;
        this.listaAutomoviles = listaAutomoviles;
    }

    public int getIdGarage() {
        return idGarage;
    }

    public ArrayList<Automovil> getListaAutomoviles() {
        return listaAutomoviles;
    }

    public void setListaAutomoviles(ArrayList<Automovil> listaAutomoviles) {
        this.listaAutomoviles = listaAutomoviles;
    }
}
