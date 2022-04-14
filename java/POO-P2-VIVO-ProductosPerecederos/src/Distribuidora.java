import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Harina",12, 2));
        productos.add(new NoPerecedero("Harina",12, "Ni idea"));
        productos.add(new Perecedero ("Harina",12,1));
        productos.add(new Perecedero ("Harina",12,3));
        productos.add(new Producto("Harina",12));

        for (Producto producto : productos){

            System.out.println(producto.toString());
            System.out.println("El precio es: "+producto.calcular(5));
        }


    }
}
