import java.util.List;
import java.util.Objects;

public class Garage {
    private Integer id_garage;
    private List<Vehiculo> vehiculos;

    public Garage(Integer id_garage, List<Vehiculo> vehiculos) {
        this.id_garage = id_garage;
        this.vehiculos = vehiculos;
    }

    public Integer getId_garage() {
        return id_garage;
    }

    public void setId_garage(Integer id_garage) {
        this.id_garage = id_garage;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(id_garage, garage.id_garage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_garage);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id_garage=" + id_garage +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
