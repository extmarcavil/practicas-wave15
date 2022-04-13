package ejemplosEstructuras;

import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");
        arrayList.add("blanco");

        System.out.println("Contenido de la lista: ");
      /*  for (int i = 0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }*/
        for (String color : arrayList) {
            System.out.println(color);
        }
        if (arrayList.contains("blanco")) {
            System.out.println("El blanco está en el listado");
        }
        arrayList.remove("blanco");
        System.out.println("¿Está el blanco?");
        for (String color : arrayList) {
            System.out.println(color);
        }
        // que pasa si uso un set
        arrayList.set(4,"amarillo");
        System.out.println("El listado quedó después de poner en pa pos 2, quedó: ");
        for (String color : arrayList) {
            System.out.println(color);
        }
        //Marca error porque la posición 4 no existe, solo las posiciones 0, 1 y 2 en este momento de la ejecución
    }
}