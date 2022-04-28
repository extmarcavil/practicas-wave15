package model;

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

    @Override
    public String toString() {
        return super.toString() + "\nPerecedero{" +
                "diasPorCauducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioParcial = super.calcular(cantidadDeProductos);
        double precioFinal = precioParcial;
        if(diasPorCaducar < 0) {
            throw new IllegalArgumentException("El producto " + getNombre() + " ya está vencido!");
        }
        if(diasPorCaducar <= 1) {
            precioFinal = precioParcial/4;
        } else {
            if(diasPorCaducar <= 2){
                precioFinal = precioParcial/3;
            }
            else {
                if(diasPorCaducar <= 3) {
                    precioFinal = precioParcial/2;
                }
            }
        }
        return precioFinal;
    }
}
