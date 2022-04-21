import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> listaDeProductos = new ArrayList<>();

        Producto producto1 = new Perecedero("Carne",  120, 1);
        Producto producto2 = new Perecedero("Queso", 50, 3);
        Producto producto3 = new Perecedero("Pan", 20, 6);
        Producto producto4 = new Perecedero("Manteca", 35, 2);
        Producto producto5 = new Perecedero("Dulce de leche", 70, 1);

        Producto producto6 = new NoPerecedero("Arroz", 50, "Tipo 2");
        Producto producto7 = new NoPerecedero("Fideos",20,"Tipo 1");
        Producto producto8 = new NoPerecedero("Azucar",70,"Tipo 3");
        Producto producto9 = new NoPerecedero("Sal",10,"Tipo 1");
        Producto producto10 = new NoPerecedero("Cafe",90,"Tipo 2");

        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);
        listaDeProductos.add(producto4);
        listaDeProductos.add(producto5);
        listaDeProductos.add(producto6);
        listaDeProductos.add(producto7);
        listaDeProductos.add(producto8);
        listaDeProductos.add(producto9);
        listaDeProductos.add(producto10);

        double total = 0;

        for (Producto producto : listaDeProductos) {
            System.out.println("\n" + producto.toString());
            int cantidad = (int) Math.floor(Math.random() * 5 + 1);
            double subtotalProductos = producto.calcular(cantidad);
            System.out.println("Cantidad: " + cantidad + " Total producto $" + subtotalProductos);
            total += subtotalProductos;
        }
    }
}
