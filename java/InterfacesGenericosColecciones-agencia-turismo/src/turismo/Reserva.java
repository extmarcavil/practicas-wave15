package turismo;

public abstract class Reserva {
    double precio;
    int cantidad;

    protected double calcularTotal(){
        return this.precio * this.cantidad;
    };
}
