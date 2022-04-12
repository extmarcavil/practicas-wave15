package herenciaYpolimorfismo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> product = new ArrayList<Producto>();

        Perecedero producto1 = new Perecedero("cafe", 80, 1);
        Perecedero producto2 = new Perecedero("leche", 80, 4);

        Perecedero producto3 = new Perecedero("harina", 100, 3);
        Perecedero producto4 = new Perecedero("azucar", 65.47, 5);
        Perecedero producto5 = new Perecedero("huevos", 99.8,3);

        product.add(producto1);
        product.add(producto2);
        product.add(producto3);
        product.add(producto4);
        product.add(producto5);


        for(Producto producto: product){
            System.out.println("El producto "+ producto.getNombre()+ " sale: " + producto.calcular(1));
        }
    }

}
