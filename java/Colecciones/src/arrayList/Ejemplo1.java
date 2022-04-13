package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos en la lista: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");
        arrayList.add("naranja");
        arrayList.add("blanco");

        System.out.println("Contenido de la lista: ");
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println("En la pos " + i + " está el color: " + arrayList.get(i));
//        }

        for (String color:arrayList) {
            System.out.println(color);
        }

        if (arrayList.contains("blanco")){
            System.out.println("El blanco está en el listado");
            arrayList.remove("Blanco");
        }
        arrayList.remove(1);

        System.out.println("---------");
        System.out.println(arrayList.get(1));
    }
}
