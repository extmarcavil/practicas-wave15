package pooSecondPractice;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public double calcular(int cantidadDeProductos) {
        double valorActual= getPrecio()*cantidadDeProductos;
        switch (diasPorCaducar){
            case 1 : valorActual=valorActual/4; break;
            case 2 : valorActual=valorActual/3; break;
            case 3 : valorActual=valorActual/2; break;
        }
        return valorActual;
    }

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
