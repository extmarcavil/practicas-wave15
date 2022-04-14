package carrera;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CarreraSelva {
    //static HashMap<Integer,HashMap> listParticipantes = new HashMap<>();
    static ArrayList<HashMap> listParticipantes = new ArrayList<>();
    static ArrayList<HashMap> listParticipantes2 = new ArrayList<>();
    static HashMap<Integer,HashMap> ciruitoChico = new HashMap<>();
    static HashMap<Integer,HashMap> ciruitoMedio = new HashMap<>();
    static HashMap<Integer,HashMap> circuitoAvanzado = new HashMap<>();

    //static int id = 1;

    public static void main(String[] args) {
        HashMap<String, String> participante1 = participante("1234","Oscar","Regino","19","30000000101","300022222","A+",""+categorias.AVANZADO);
        HashMap<String, String> participante2 = participante("4567","Juan","Rozo","19","30000000101","300022222","B-",""+categorias.MEDIO);
        HashMap<String, String> participante3 = participante("8910","Benito","Perez","19","30000000101","300022222","A-",""+categorias.CHICO);
        HashMap<String, String> participante4 = participante("4333","Raul","Soto","11","30000000101","300022222","B-",""+categorias.AVANZADO);

        agregarParticipante(participante1);
        agregarParticipante(participante2);
        agregarParticipante(participante3);
        agregarParticipante(participante4);

        asignarCircuito();

        System.out.println("Circuito chico");
        imprimirCategoria(ciruitoChico);
        System.out.println("Circuito avanzado");
        imprimirCategoria(circuitoAvanzado);
        System.out.println("Circuito medio");
        imprimirCategoria(ciruitoMedio);

        montoAPagar();

    }

    public  enum categorias {
        CHICO,MEDIO,AVANZADO
    }

    public static HashMap<String, String> participante(String dni, String nombre, String apellido, String edad, String celular, String numEmr, String RH, String circuito){
        HashMap<String, String> persona1 = new HashMap<String, String>();
        persona1.put("dni",dni);
        persona1.put("nombre",nombre);
        persona1.put("apellido",apellido);
        persona1.put("edad",edad);
        persona1.put("celular",celular);
        persona1.put("numEm",numEmr);
        persona1.put("Rh",RH);
        persona1.put("Circuito",circuito);
        return  persona1;
    }

    public static void agregarParticipante(HashMap participante){
        if(participante.get("Circuito").equals(""+categorias.AVANZADO) && Integer.parseInt((String) participante.get("edad"))< 18){
            System.out.println("No se puede inscribir menores de edad a esta categoria");
        }else {
            if (listParticipantes.size() == 0) {
                listParticipantes.add(participante);
            } else {
                if (!listParticipantes.contains(participante)) {
                    listParticipantes2.add(participante);
                } else {
                    System.out.println("El participante con cedula " + participante.get("dni") + " ya se encuentra inscrito");
                }
            }
            listParticipantes.addAll(listParticipantes2);
            listParticipantes2.clear();
        }
    }

    public static void asignarCircuito(){
        for (HashMap p: listParticipantes) {
            String circuito = (String) p.get("Circuito");
            switch(circuito){
                case "CHICO":
                    ciruitoChico.put(ciruitoChico.size()+1,p);
                    break;

                case "MEDIO":
                    ciruitoMedio.put(ciruitoMedio.size()+1,p);
                    break;

                case "AVANZADO":
                    circuitoAvanzado.put(circuitoAvanzado.size()+1,p);
                    break;
            }
        }
    }

    public static void imprimirLista(){
        for (HashMap part : listParticipantes) {
            System.out.println(part);
        }
    }

    public  static  void imprimirCategoria(HashMap categoria){
        categoria.forEach((k,v)-> System.out.println("id: " + k + " Participante " + v));
    }

    public  static  void eliminarPArticipante(String categoria, int id){
        switch(categoria){
            case "CHICO":
                ciruitoChico.remove(id);
                break;

            case "MEDIO":
                ciruitoMedio.remove(id);
                break;

            case "AVANZADO":
                circuitoAvanzado.remove(id);
                break;
        }
    }

    public static void montoAPagar(){
        for (HashMap part : listParticipantes) {
            String circuito = (String) part.get("Circuito");
            int edad = Integer.parseInt((String) part.get("edad"));
            String nombre = (String) part.get("nombre");
            String dni = (String) part.get("dni");
            int valorPagar = 0;

            switch(circuito){
                case "CHICO":
                    if(edad<18) valorPagar= 1300;
                    else  valorPagar = 1500;
                    break;

                case "MEDIO":
                    if(edad<18) valorPagar= 2000;
                    else  valorPagar = 2300;
                    break;

                case "AVANZADO":
                    valorPagar = 2800;
                    break;
            }

            System.out.println("El participante "+ nombre + " con dni " + dni + " incrito al circuito "
                    + circuito + " debe pagar " + valorPagar);
        }
    }
}


