package herenciaYPolimorfismo;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        Perecedero p = new Perecedero("Manteca", 200, 5);
        listaProductos.add(p);
        p = new Perecedero("Leche", 100, 2);
        listaProductos.add(p);
        p = new Perecedero("Tomate", 200, 1);
        listaProductos.add(p);
        p = new Perecedero("Yogurt", 150, 4);
        listaProductos.add(p);
        p = new Perecedero("Queso", 500, 7);
        listaProductos.add(p);

        NoPerecedero p1 = new NoPerecedero("Arroz", 90, "A");
        listaProductos.add(p1);

        for(Producto pd: listaProductos){
            System.out.print(pd);
            System.out.println(" Precio total:" + pd.calcular(5));
        }
    }
}
