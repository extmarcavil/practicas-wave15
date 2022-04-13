package arrayList;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");

        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("blanco");
        System.out.println("Nro de elementos: " + arrayList.size());

        System.out.println("El elemento que hay en la pos 1: " + arrayList.get(1));


        System.out.println("Contenido de la lista 1");
        for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        
        System.out.println("Contenido de la lista 2 - FOREACH");
        for (String color : arrayList){
            System.out.println(color);
        }

        if (arrayList.contains("blanco")){
            System.out.println("El blanco está en la lista");
        }

        arrayList.remove("blanco");
        arrayList.remove(1);

        // que pasa si uso un set?

        arrayList.set(1, "amarillo");
        
        

    }
}
