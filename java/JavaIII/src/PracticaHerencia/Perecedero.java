package PracticaHerencia;

public class Perecedero extends Producto{
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

    public String toString(){
        String prev = super.toString();
        return prev + ", " + diasPorCaducar + " días por caducar";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return precio / 4;
        } else if (diasPorCaducar == 2) {
            return precio / 3;
        } else if (diasPorCaducar == 3) {
            return precio / 2;
        } else {
            return precio;
        }
    }
}
