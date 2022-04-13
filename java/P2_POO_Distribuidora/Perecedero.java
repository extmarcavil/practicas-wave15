package P2_POO_Distribuidora;

import P2_POO_Distribuidora.Producto;

public class Perecedero extends Producto {
    int diasPorCalcular=0;

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCalcular=" + diasPorCalcular +
                '}';
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public Perecedero(String nombre, double precio, int diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public double calcular(int cantidadProductos){
        double reduccion=0;
        if(diasPorCalcular==1){
            reduccion=this.getPrecio()/4;
        }else if(diasPorCalcular==2){
            reduccion=this.getPrecio()/3;
        }else if(diasPorCalcular==3){
            reduccion=this.getPrecio()/2;
        }
        return (this.getPrecio()*cantidadProductos) - reduccion;
    }
}
