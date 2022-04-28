package integradora;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar, int precio, String nombre) {
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
                "precio=" + getPrecio() +
                "nombre=" + getNombre() +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = getPrecio() * cantidadDeProductos;

        if(diasPorCaducar == 1) return resultado - (resultado / 4);
        else if(diasPorCaducar == 2) return resultado - (resultado / 3);
        if(diasPorCaducar == 3) return resultado - (resultado / 2);

        return  resultado;
    }
}
