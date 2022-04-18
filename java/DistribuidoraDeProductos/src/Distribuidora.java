import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero arroz = new Perecedero("Arroz", 95, 1);
        NoPerecedero leche = new NoPerecedero("Leche", 105, "lacteo");
        Perecedero fideo = new Perecedero("Fideo", 78, 3);
        NoPerecedero queso = new NoPerecedero("Queso", 200, "lacteo");
        Perecedero galleta = new Perecedero("Galleta", 155, 30);

        productos.add(arroz);
        productos.add(leche);
        productos.add(fideo);
        productos.add(queso);
        productos.add(galleta);

        double precioTotal = 0;

        for (Producto producto: productos) {
            precioTotal = producto.calcular(2);
        }

        System.out.println("Precio total: $" + precioTotal);
    }
}
