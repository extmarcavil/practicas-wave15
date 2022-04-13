package linkedlist;

import java.util.LinkedList;

public class Ejemplo1 {
    public static void imprimir (LinkedList<String> lista){
        for (String elemento : lista)
            System.out.print(elemento  + " - ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Independiente");
        lista1.add("San Lorenzo");
        lista1.add("River");
        imprimir(lista1);
        lista1.add(1,"boca");
        imprimir(lista1);
        lista1.remove(2);
        System.out.println("cantidad de items actual : " + lista1.size());
        if (lista1.contains("boca")) {
            System.out.println("boca esta en la lista");
        }else{
            System.out.println("boca no esta en la lista");
        }
        System.out.println("el segundo elemento es " + lista1.get(1));
        lista1.clear();
        if(lista1.isEmpty()) {
            System.out.println("la lista esta vacia");
        }else{
            System.out.println("la lista esta vacian't");
        }
    }
}
