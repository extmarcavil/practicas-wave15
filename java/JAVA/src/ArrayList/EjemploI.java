package ArrayList;

import java.util.ArrayList;

public class EjemploI {

    public static void main(String[] args) {
    //arraylist se llama variabel de objeto
        ArrayList <String> arrayList  = new ArrayList<String>();
        System.out.println("Listar numero de elementos :" + arrayList.size());

        arrayList.add("Rosa");
        arrayList.add("Verde");
        arrayList.add("Azul");

        System.out.println("Elementos: " + arrayList.size());
        arrayList.add("Blanco");

        System.out.println("El elemento que hay en la posicion 1 " + arrayList.get(1));

        /**for( int i = 0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
         */

        //no hace falta el get, va directo la variable del String
        for (String color : arrayList) {
            System.out.println(color);
        }

        if(arrayList.contains("Blanco")){
            System.out.println("Contiene el blanco");


        }

        arrayList.remove("Blanco");
        System.out.println("¿Esta el Blanco?");

        for (String color : arrayList){
            System.out.println(color);
        }

        // q pasa si uso set
        arrayList.set(2, "Negro");

        arrayList.remove(1);

        System.out.println("El listado quedo asi despues de agregar en la posicion 2, negro : ");

        for(String color : arrayList){
            System.out.println(color);
        }




    }
}
