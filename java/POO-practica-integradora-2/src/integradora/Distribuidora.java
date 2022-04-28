package integradora;

public class Distribuidora {

        public static void main(String[] args) {
               Producto[] productos = new Producto[5];

                System.out.println("***Distribuidora***");
                System.out.println("\n---Agregando productos perecederos---");

                productos[0] = new Perecedero(3, 300, "Manzana");
                productos[1] = new Perecedero(2, 400, "Yogurth");
                productos[2] = new Perecedero(1, 500, "Pera");
                productos[3] = new Perecedero(0, 800, "Queso");
                productos[4] = new Perecedero(5, 100, "Pollo");

                System.out.println("\nLista final");
                for (int i = 0; i < 5; i++) {
                        System.out.println(productos[i].toString());
                }

                System.out.println("\n---Agregando productos no perecederos---");

                productos[0] = new NoPerecedero("1", 300, "Manzana");
                productos[1] = new NoPerecedero("2", 400, "Yogurth");
                productos[2] = new NoPerecedero("3", 500, "Pera");
                productos[3] = new NoPerecedero("4", 800, "Queso");
                productos[4] = new NoPerecedero("5", 100, "Pollo");

                System.out.println("\nLista final");
                for (int i = 0; i < 5; i++) {
                        System.out.println(productos[i].toString());
                }
        }
}
