import java.util.ArrayList;
import java.util.List;

public class Garage {

    Integer id;
    List<Vehiculo> vehiculos;

    public Garage(Integer id) {
        this.id = id;
          vehiculos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
