package herenciaYPolimorfismo;

public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        int reductor = 1;
        if(diasPorCaducar == 1){
            reductor = 4;
        }else{
            if(diasPorCaducar == 2){
                reductor = 3;
            }else{
                if(diasPorCaducar == 3){
                    reductor = 2;
                }
            }
        }

        return (cantidadDeProductos*precio)/reductor;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero {" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
