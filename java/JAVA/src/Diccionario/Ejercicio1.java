package Diccionario;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();

        mapa.put(924, "Martin Marquez");
        mapa.put(252, "Armando Lopez");
        mapa.put(132, "Alan Brito");
        mapa.put(454, "Ricardo Bochini");

        System.out.println("Los alumnos son " + mapa);
        // imp clave valor,

        System.out.println(mapa.get(454));

        // Si queremos mas salidas usamos entry set

        System.out.println("con entrySet");
        System.out.println(mapa.entrySet());
        System.out.println("listado uno a uno");

        for(Map.Entry pareja : mapa.entrySet()){
            System.out.println(pareja);
        }

        System.out.println("Codigo\tNombre\n-------\t------------");

        for(Map.Entry pareja: mapa.entrySet()){
            System.out.println(pareja.getKey() + "\t");
            System.out.println(pareja.getValue());
        }

        //tNombre salto de linea
        //n salto de linea
    }
}
