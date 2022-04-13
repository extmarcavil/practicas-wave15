import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {
    private Long id;
    List<Vehiculo> vehiculos;

    public Garaje(Long id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculosPorPrecioMenorAMayor() {
        return this.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosPorMarcaYPorPrecio() {
        Comparator<Vehiculo> comp = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto);

        return this.getVehiculos()
                .stream()
                .sorted(comp)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosConPrecioMenorA1000() {
        return this.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosConPrecioMayorOIgualA1000() {
        return this.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());
    }

    public Float getPrecioPromedio() {
        return this.getVehiculos()
                .stream()
                .map(Vehiculo::getCosto)
                .reduce(0f, Float::sum) / this.getVehiculos().size();
    }
}
