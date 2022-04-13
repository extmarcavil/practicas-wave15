package diccionarios;

import java.util.HashMap;

public class EjemploD {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa= new HashMap<Integer,String>();
        mapa.put(924,"Marin Marquez");
        mapa.put(252,"Armando Paredes");
        mapa.put(132,"Alan Brito");
        mapa.put(454,"Ricardo Bochini");
        System.out.println("Los Alumnos son "+ mapa);
        System.out.println(mapa.get(454));
        System.out.println(mapa.get(454));

    }
    }

