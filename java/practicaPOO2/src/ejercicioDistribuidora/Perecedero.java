package ejercicioDistribuidora;

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
        return super.toString() + " - diasPorCaducar=" + diasPorCaducar;
    }

    @Override
    public double calcular (int cantidadDeProductos) {
        double resta;
        if (diasPorCaducar > 3) {
            return this.getPrecio()*cantidadDeProductos;
        }
        else if (diasPorCaducar == 1) {
            resta = (this.getPrecio()/4);
            return (resta*cantidadDeProductos);
        } else if (diasPorCaducar == 2) {
            resta = (this.getPrecio()/3);
            return (resta*cantidadDeProductos);
        } else {
            resta = (this.getPrecio()/2);
            return (resta*cantidadDeProductos);
        }
    }
}
