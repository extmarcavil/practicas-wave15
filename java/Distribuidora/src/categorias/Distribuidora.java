package categorias;

public class Distribuidora {
    public static void main(String[] args) {
        Producto productos[] = new Producto[5];
        productos[0] = new Perecedero("Leche", 24.0, 3);
        productos[1] = new Perecedero("Pan", 28.0, 2);
        productos[2] = new Perecedero("Yogurt", 23.0, 1);
        productos[3] = new Perecedero("Atún", 30, 30);
        productos[4] = new NoPerecederos("Agua", 18, "Bebibles");

        for (Producto p:productos) {
            System.out.println(p.toString() + " Total: " + p.Calcular(5));
        }
    }
}
