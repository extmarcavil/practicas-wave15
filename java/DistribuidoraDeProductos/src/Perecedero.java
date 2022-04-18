public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double reducirPrecio = 0;
        double precioCalculado = super.calcular(cantidadDeProductos);

        if(diasPorCaducar == 1) {
            reducirPrecio = precioCalculado / 4;
        } else if (diasPorCaducar == 2) {
            reducirPrecio = precioCalculado / 3;
        } else if(diasPorCaducar == 3) {
            reducirPrecio = precioCalculado / 2;
        }
        return precioCalculado - reducirPrecio;
    }
}
