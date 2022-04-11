import model.NoPerecedero;
import model.Perecedero;
import model.Producto;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Producto1P", 10, 3);
        productos[1] = new Perecedero("Producto2P", 10.5, 2);
        productos[2] = new Perecedero("Producto3P", 11, 1);
        productos[3] = new Perecedero("Producto4P", 11.5, 3);
        productos[4] = new Perecedero("Producto5P", 12, 2);
        productos[5] = new NoPerecedero("Producto1NP", 10, "Tipo 1");
        productos[6] = new NoPerecedero("Producto2NP", 10.5, "Tipo 2");
        productos[7] = new NoPerecedero("Producto3NP", 11, "Tipo 3");
        productos[8] = new NoPerecedero("Producto4NP", 11.5, "Tipo 4");
        productos[9] = new NoPerecedero("Producto5NP", 12, "Tipo 5");

        double precioTotal = 0;

        for (int i = 0; i < productos.length; i++) {
            System.out.print("Producto comprado: " + productos[i].getNombre());
            System.out.print(" --- Cantidad comprada: " + (i + 1));
            System.out.println(" --- Precio/unidad: " + productos[i].getPrecio());
            try {
                precioTotal += productos[i].calcular(i+1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(" ------------- ");
        System.out.println("Precio total de la compra: $" + precioTotal);
    }
}
