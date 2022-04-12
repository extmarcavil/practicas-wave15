package Distribuidora;

public class Distribuidora {
    public static void main(String[] args) {
        Producto producto1 = new Perecedero("Leche", 10, 2);
        Producto producto2 = new Perecedero("Harina", 20, 3);
        Producto producto3 = new Perecedero("Yogur", 30, 0);
        Producto producto4 = new NoPerecedero("Polenta", 40, "tipo1");
        Producto producto5 = new NoPerecedero("Arroz", 50, "tipo2");

        Producto[] productos = {producto1, producto2, producto3, producto4, producto5};

        for (Producto producto : productos) {
            System.out.println("Total de vender 5 " + producto.getNombre() + ": " + producto.calcular(5));
        }
    }
}
