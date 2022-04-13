package POO;

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
        return "Producto: " + getNombre() + "\tPrecio: $" + getPrecio();
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precio_final = getPrecio();
        if(diasPorCaducar == 3)
            return cantidadDeProductos * (precio_final/2);
        else if (diasPorCaducar == 2)
            return cantidadDeProductos * (precio_final/3);
        else if (diasPorCaducar == 1)
            return cantidadDeProductos * (precio_final/4);
        else
            return cantidadDeProductos * precio_final;
    }
}
