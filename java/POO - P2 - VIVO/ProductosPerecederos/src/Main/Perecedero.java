package Main;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public void calcular(int cantidadDeProductos) {

        switch (cantidadDeProductos) {
            case 1:
                this.precio = this.precio / 4;
                break;
            case 2:
                this.precio = this.precio / 3;
                break;
            case 3:
                this.precio = this.precio / 2;
                break;
        }

        System.out.println(this.precio);
    }

}
