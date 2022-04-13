package herencia;

public class Perecedero extends  Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCadudar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCadudar;
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
                super.toString() +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = cantidadDeProductos * super.getPrecio();
        switch ( diasPorCaducar ) {
            case 1:
                resultado = resultado / 4 ;
                break;
            case 2:
                resultado = resultado / 3;
                break;
            case 3:
                resultado = resultado / 2;
                break;
        }
        return resultado;

    }
}
