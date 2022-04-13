package POO.P2.Ejercicio2;

public class Perecedero extends Producto {

    private int diasPorCaducar;


    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTotal =  super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1)
            precioTotal /= 4;
        else if (diasPorCaducar == 2)
            precioTotal /= 3;
        else if (diasPorCaducar == 3)
            precioTotal /= 2;

        return precioTotal;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Caduca en " + diasPorCaducar + " días";
    }
}
