package DistribuidoraDeProductos;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(){}

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        switch (diasPorCaducar){
            case 1:
                precio = getPrecio() * 1/4;
                break;
            case 2:
                precio = getPrecio() * 1/3;
                break;
            case 3:
                precio = getPrecio() * 1/2;
                break;
            default:

        }

        return super.calcular(cantidadDeProductos);
    }
}
