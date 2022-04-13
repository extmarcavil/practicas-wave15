package HerenciaPolimorfismoYEncapsulamiento;

public class Perecedero extends Producto {

    protected int diasPorCaducar;

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
    public String calcular(int cantidadProducto) {
        double precio = cantidadProducto * getPrecio();

        switch(getDiasPorCaducar()){
            case 1:
                precio = precio / 4;
                break;
            case 2:
                precio = precio / 3;
                break;
            case 3:
                precio = precio / 2;
                break;
        }

       return " El precio por " + cantidadProducto + " " + getNombre() + " es " + precio;
    }

    public String toString(){
        return super.toString() + " Dias por caducar: " + getDiasPorCaducar();
    }


}
