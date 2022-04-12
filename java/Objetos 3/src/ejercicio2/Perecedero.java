package ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nomnbre, double precio, int diasPorCaducar) {
        super(nomnbre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero() {

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
    public double calcular(int cantidadDeProductos){

        if(diasPorCaducar == 1){
            return cantidadDeProductos*(this.getPrecio()/4);
        }
        else if(diasPorCaducar == 2){
            return cantidadDeProductos*(this.getPrecio()/3);
        }
        else if (diasPorCaducar == 3){
            return cantidadDeProductos*(this.getPrecio()/2);
        }
        else {
            return cantidadDeProductos * this.getPrecio();
        }
    }
}
