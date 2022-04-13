package AgenciaTurismo;

public class Comida {
    @Override
    public String toString() {
        return "Comida{" +
                "precio=" + precio +
                '}';
    }

    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Comida(double precio) {
        this.precio = precio;
    }
}
