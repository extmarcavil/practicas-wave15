package ejercicioPOOP2Vivo;

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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidDeProductos){
        double resultado = super.getPrecio() * cantidDeProductos;

        switch (this.diasPorCaducar) {
            case 1:
                resultado = resultado/4;
                break;
            case 2:
                resultado = resultado/3;
                break;
            case 3:
                resultado = resultado/2;
                break;
            default:
                resultado = resultado;
                break;

        }

        return resultado;
    }
}
