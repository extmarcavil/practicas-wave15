package ejercicio2;

import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> ventas= List.of(
                new Perecedero("Leche",8.0,2),
                new NoPerecedero("Fideo Moñito",7.,"No se")
        );

        System.out.println(ventas);
        System.out.println("Venta total: "+
                ventas.stream()
                        .mapToDouble(p-> p.calcular(5))
                        .sum()
        );
    }
}
