package diccionarios;

import java.util.HashMap;

public class Ejemplo1 {



    public static void main(String[] args) {
        HashMap<String,String> diccionario1 = new HashMap<String,String>();

        diccionario1.put("Nombre","Propiedad de todo ser humano");
        diccionario1.put("diccionario", "lugar donde hay palabras");
        diccionario1.put("programar", "escribir código");
        diccionario1.put("padres", "personas que engendraron un hijo");

        System.out.println(diccionario1.get("Nombre"));
    }
}
