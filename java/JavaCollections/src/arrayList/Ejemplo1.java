package arrayList;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Número de elementos: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");
        arrayList.add("blanco");
        System.out.println("Contenido de la lista: ");
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}
