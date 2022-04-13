import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        double suma = 0;

        Producto pan = new Perecedero("pan", 80, 5);
        Producto leche = new NoPerecedero("leche larga vida", 100, "lacteo");
        Producto jugo = new NoPerecedero("jugo", 50, "bebida");
        Producto chocolate = new Perecedero("fideos frescos", 130, 2);
        Producto azucar = new NoPerecedero("azucar", 99, "alimento");

        Producto[] productos = {pan, leche, jugo, chocolate, azucar};

        for(Producto producto : productos){

            suma += producto.calcular(5);
        }
        System.out.println(suma);
    }
}
