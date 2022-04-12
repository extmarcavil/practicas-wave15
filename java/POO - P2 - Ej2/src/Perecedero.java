public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double calculo = cantidadDeProductos * this.precio;
        if(this.diasPorCaducar == 1){
            return calculo/4;
        }
        if (this.diasPorCaducar == 2){
            return calculo/3;
        }
        if(this.diasPorCaducar == 3){
            return  calculo/2;
        }
        return 0;
    }
}
