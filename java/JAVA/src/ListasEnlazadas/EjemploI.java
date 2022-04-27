package ListasEnlazadas;

import java.util.LinkedList;

public class EjemploI {

    public static void  imprimir(LinkedList<String> lista){
        for(String elemento : lista){
            System.out.println(elemento  +  " - ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> lista1  = new LinkedList<String>();
        lista1.add("Independiente");
        lista1.add("San Lorenzo");
        lista1.add("River");

        imprimir(lista1);
        lista1.add(1,"Boca");
        imprimir(lista1);
        lista1.remove(2);
        imprimir(lista1);
        System.out.println("Cantidad de equipos que tenemos" + lista1.size());

        if (lista1.contains("Boca")) {
            System.out.println("Esta en la lista boca ");
        }
        else{
            System.out.println("No esta Boca en la lista");
        }

        System.out.println("El segundo equipo es: " +lista1.get(1));
        lista1.clear();

        if(lista1.isEmpty()){
            System.out.println("La lista esta vacia");
        } else {
            System.out.println("La lista tiene elementos");
        }

    }

    }

