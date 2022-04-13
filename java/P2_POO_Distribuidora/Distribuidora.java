package P2_POO_Distribuidora;

import P2_POO_Distribuidora.NoPerecedero;
import P2_POO_Distribuidora.Perecedero;
import P2_POO_Distribuidora.Producto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        LinkedList<Producto> productos = new LinkedList<>();
        productos.add(0,new Perecedero("Carne",100,2));
        productos.add(1,new Perecedero("Fruta",100,2));
        productos.add(2,new Perecedero("Verdura",1200,3));
        productos.add(3,new Perecedero("Pescado",130,1));
        productos.add(4,new Perecedero("Queso",400,4));
        productos.add(5,new Perecedero("Leche",1050,5));

        productos.add(6,new NoPerecedero("Atun",2600,"1"));
        productos.add(7,new NoPerecedero("Pastas",2700,"2"));
        productos.add(8,new NoPerecedero("Azucar",800,"3"));
        productos.add(9,new NoPerecedero("Cafe",900,"1"));
        productos.add(10,new NoPerecedero("Arroz",1100,"2"));


        for (Producto p : productos){
            System.out.println("Producto: "+p.getNombre()+" | Precio final: "+p.calcular(2));
        }

    }
}
