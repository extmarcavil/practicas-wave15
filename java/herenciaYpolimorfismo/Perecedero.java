package herenciaYpolimorfismo;

public class Perecedero extends Producto{

    int diasPorCaducar;

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
    public double calcular(int cantDeProductos) {
        double operacion = precio * cantDeProductos;
        if (diasPorCaducar == 1) return operacion / 4;
        if (diasPorCaducar == 2) return operacion / 3;
        if (diasPorCaducar == 3) return operacion / 2;
        return operacion;
    }
}

