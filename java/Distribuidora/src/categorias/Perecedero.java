package categorias;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() + '\'' +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double Calcular(int cantidadDeProductos) {
        switch (diasPorCaducar){
            case 1:
                return super.Calcular(cantidadDeProductos)*0.25;
            case 2:
                return super.Calcular(cantidadDeProductos)*(1.0/3.0);
            case 3:
                return super.Calcular(cantidadDeProductos)*0.5;
            default:
                return super.Calcular(cantidadDeProductos);
        }

    }
}
