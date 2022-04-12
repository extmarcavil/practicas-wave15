package exc_ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantProductos) {
        switch (diasPorCaducar) {
            case 1:
                return super.calcular(cantProductos) - getPrecio() * 4;
            case 2:
                return super.calcular(cantProductos) - getPrecio() * 3;
            case 3:
                return super.calcular(cantProductos) - getPrecio() * 2;
        }
        return super.calcular(cantProductos);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPerecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
