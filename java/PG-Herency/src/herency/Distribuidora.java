package herency;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Distribuidora {
    // Crear una clase ejecutable llamada Distribuidora donde van a
    // crear un array de productos, imprimir el precio total al vender
    // 5 productos de cada tipo. Crear los elementos del array con los
    // datos que quieras.

    public static void main(String[] args) {
        ArrayList<Producto> listaDeProductos = new ArrayList<>();

        listaDeProductos.add(new Perecedero("Leche",150,1));
        listaDeProductos.add(new Perecedero("Cereal",330,900));
        listaDeProductos.add(new Perecedero("Queso",1000,1));
        listaDeProductos.add(new Perecedero("Fideos",100,2));
        listaDeProductos.add(new Perecedero("Aceite",500,1));

        listaDeProductos.add(new NoPerecedero("Miel",500,"Dulce"));
        listaDeProductos.add(new NoPerecedero("Lenteja",200,"Legumbre"));
        listaDeProductos.add(new NoPerecedero("Heladera",50000,"Electrodomestico"));
        listaDeProductos.add(new NoPerecedero("Sal",100,"Salado"));
        listaDeProductos.add(new NoPerecedero("Silla Gamer",50000,"Games"));


        for(Producto cadaProducto : listaDeProductos){
            System.out.println("El producto "+cadaProducto.getNombre()+" vale $" + cadaProducto.calcular(1));
        }

    }
}
