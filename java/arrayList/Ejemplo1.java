package arrayList;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<String>();
        System.out.println("Numero de Elementos: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("azul");
        arrayList.add("verde");
        System.out.println("Numero de Elementos: " + arrayList.size());
        arrayList.add("blanco");
        System.out.println("El elemento en la poscicion 0 es :" + arrayList.get(0));
      //  for (int i = 0 ; i< arrayList.size();i++){
      //      System.out.println(arrayList.get(i));
      //  }
        for (String color: arrayList){
            System.out.println(color);
        }
        if(arrayList.contains("blanco")) {
            System.out.println(" pos si tiene el blanco xd");
        }
        arrayList.remove("blanco");
        System.out.println("blanco doko?");
        for (String color: arrayList){
            System.out.println(color);
        }
        arrayList.remove(1);
        System.out.println("ahora es un listadon't");
        for (String color: arrayList){
            System.out.println(color);
        }

    }
}
