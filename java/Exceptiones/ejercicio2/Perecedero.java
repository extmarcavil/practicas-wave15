package ejercicio2;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if (this.diasPorCaducar == 1) {
            this.setPrecio(this.getPrecio() - 4);
        } else if (this.diasPorCaducar == 2) {
            this.setPrecio(this.getPrecio() - 3);
        } else if (this.diasPorCaducar == 3) {
            this.setPrecio(this.getPrecio() / 2);
        }
        return this.getPrecio() * cantidadDeProductos;
    }

    public String toString() {
        return "Nombre: " + this.getNombre() + " Precio: " + this.getPrecio() + " días por caducar: " + this.diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
