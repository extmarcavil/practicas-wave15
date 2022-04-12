package generigcWrapperLambdaStreams;

import java.util.ArrayList;

public class Garage {

    private Integer id;
    private ArrayList<Vehicle> vehicles;

    public Garage(Integer id, ArrayList<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
