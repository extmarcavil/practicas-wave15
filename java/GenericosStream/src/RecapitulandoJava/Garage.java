package RecapitulandoJava;

import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> autos;

    public Garage(int id, List<Vehiculo> autos) {
        this.id = id;
        this.autos = autos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getAutos() {
        return autos;
    }

    public void setAutos(List<Vehiculo> autos) {
        this.autos = autos;
    }

    public void addAuto (Vehiculo auto) {
        autos.add(auto);
    }
}
