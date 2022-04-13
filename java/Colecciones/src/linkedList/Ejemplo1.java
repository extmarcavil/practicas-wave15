package linkedList;

import java.util.LinkedList;

public class Ejemplo1 {
    public static void imprimir(LinkedList<String> lista){
        for (String elemento:lista) {
            System.out.print("elemento:" + " - " + elemento);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<String>();
        lista1.add("Erevan");
        lista1.add("Buenos Aires");
        lista1.add("Atenas");

        imprimir(lista1);
        System.out.println("----------");

        lista1.add(1,"Montevideo");
        imprimir(lista1);

        lista1.remove("Atenas");
        System.out.println("-------------");

        System.out.println(lista1.get(2));
    }
}
