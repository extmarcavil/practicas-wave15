package linkedList;

import java.util.LinkedList;

public class Ejemplo1 {

    public static void imprimir (LinkedList<String> lista){
        for (String elemento : lista){
            System.out.print(elemento + " - ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Independiente");
        lista1.add("San Lorenzo");
        lista1.add("River");


        imprimir(lista1);

        lista1.add(1,"Boca");
        imprimir(lista1);

        lista1.remove(2);
        imprimir(lista1);

        System.out.println("Cantidad de equipos: " + lista1.size());

        if(lista1.contains("Boca"))
            System.out.println("Boca si está");
        else
            System.out.println("Boca no está en la lista");

        System.out.println("El segundo equipo es: " + lista1.get(1));

        lista1.clear();
        if(lista1.isEmpty())
            System.out.println("La lista esta vacía");
        else
            System.out.println("La lista tiene elementos");


    }
}

