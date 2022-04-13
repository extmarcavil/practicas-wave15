package DistribuidoraDeProductos;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String [] Args){
        ArrayList productos = new ArrayList<>();

        Perecedero leche = new Perecedero(5);
        productos.add(leche);
        leche.calcular(1);

    }
}
