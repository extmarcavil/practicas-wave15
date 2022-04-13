package POO;

import java.util.ArrayList;
import java.util.LinkedList;

public class Distribuidora {
    public static void main(String[] args) {
        LinkedList<Producto> listado = new LinkedList<>();

        Perecedero leche = new Perecedero("Leche",100,3);
        listado.add(leche);
        Perecedero ketchup = new Perecedero("Ketchup",80,20);
        listado.add(ketchup);
        Perecedero carne = new Perecedero("Carne",250,2);
        listado.add(carne);
        Perecedero pescado = new Perecedero("Pescado",450,1);
        listado.add(pescado);
        Perecedero rucula = new Perecedero("Rucula",85,1);
        listado.add(rucula);

        NoPerecedero arroz = new NoPerecedero("Arroz",50,"Cereal");
        listado.add(arroz);
        NoPerecedero atun = new NoPerecedero("Atun",300,"Animal");
        listado.add(atun);
        NoPerecedero leche_larga = new NoPerecedero("Leche larga vida",120,"Lacteo");
        listado.add(leche_larga);
        NoPerecedero almendras = new NoPerecedero("Almendras",450,"Cereal");
        listado.add(almendras);
        NoPerecedero manteca = new NoPerecedero("Manteca",150,"Lacteo");
        listado.add(manteca);

        for(Producto prod : listado){
            System.out.println(prod.toString());
        }

    }
}
