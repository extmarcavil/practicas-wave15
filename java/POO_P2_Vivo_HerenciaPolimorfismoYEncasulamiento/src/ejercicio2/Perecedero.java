package ejercicio2;

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
    public double calcular(int cantidadDeProductos){
        double valor = cantidadDeProductos * getPrecio();

        switch (getDiasPorCaducar()){
            case 1:
                valor = valor/4;
                break;

            case 2:
                valor = valor/3;
                break;

            case 3:
                valor = valor / 2;
                break;

            default:
                valor = valor;
                break;
        }
        return  valor;
    }
}
