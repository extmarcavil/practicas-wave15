package AgenciaTurismo;

public class ReservaHotel {

    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ReservaHotel(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "precio=" + precio +
                '}';
    }
}
