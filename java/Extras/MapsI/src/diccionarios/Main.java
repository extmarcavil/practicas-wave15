package diccionarios;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();
        mapa.put(924, "Martin Marquez");
        mapa.put(252, "Armando Paredes");
        mapa.put(132, "Alan Brito");
        mapa.put(454, "Ricardo Bochini");
        System.out.println("Los alumnos son: " + mapa);

        System.out.println(mapa.get(454));
        System.out.println(mapa.get(999));

        System.out.println("con entrySet");
        System.out.println(mapa.entrySet());
        System.out.println("listado uno a uno: ");
        for(Map.Entry pareja : mapa.entrySet()){
            System.out.println(pareja);
        }

        System.out.println("Codigo\t\tNombre\n---\t\t----------");
        for(Map.Entry pareja : mapa.entrySet()){
            System.out.print(pareja.getKey() + "\t\t");
            System.out.println(pareja.getValue() + "\t\t");
        }
    }
}
