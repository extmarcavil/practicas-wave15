package EjercicioPractico2POO;


import java.util.ArrayList;

public class Distrubudora {
    public static void main(String[] args) {
        ArrayList <Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(new Perecedero("Aceite",2500,30));
        listaDeProductos.add(new Perecedero("Cebolla",1000,60));
        listaDeProductos.add(new Perecedero("Salsa de tomate",800,2));
        listaDeProductos.add(new Perecedero("Mantequilla",990,1));
        listaDeProductos.add(new Perecedero("Soja",890,90));

        listaDeProductos.add(new NoPerecedero("Sal",890,"Especia"));
        listaDeProductos.add(new NoPerecedero("Tallarines",1200,"Pastas"));
        listaDeProductos.add(new NoPerecedero("Cafe",1500,"Cafeina"));
        listaDeProductos.add(new NoPerecedero("Azucar",990,"Endulzante"));
        listaDeProductos.add(new NoPerecedero("Lentejas",1200,"Legumbres"));

        for(Producto todosLosProductos :listaDeProductos){
            System.out.println(todosLosProductos.nombre + ": $" + ((int) todosLosProductos.precio));
        }
    }

}
