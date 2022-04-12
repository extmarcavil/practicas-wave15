package ejercicioPOOP2Vivo;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero leche = new Perecedero("Leche La Serenisima", 130.0, 1);
        double precioLeche = leche.calcular(5);
        System.out.println("El precio de 5 leches es: " +precioLeche);
        productos.add(leche);

        Producto arroz = new NoPerecedero("Arroz", 130.0, "Arroz");
        double precioArroz = arroz.calcular(5);
        System.out.println("El precio de 5 paquetes de arroz es: " +precioArroz);
        productos.add(arroz);
        
    }
}
