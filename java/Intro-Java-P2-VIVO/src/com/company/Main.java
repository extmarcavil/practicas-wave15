package com.company;

import java.text.ParsePosition;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * Informacion de los participantes
         */
        Map<String, String> participante1 = new LinkedHashMap<>();
        participante1.put("dni", "1");
        participante1.put("nombre", "Pedro Perez");
        participante1.put("edad", "17");
        participante1.put("celular", "12345");
        participante1.put("grupo sanguineo", "o+");
        participante1.put("categoria", "circuito chico");

        Map<String, String> participante2 = new LinkedHashMap<>();
        participante2.put("dni", "2");
        participante2.put("nombre", "Juan Perez");
        participante2.put("edad", "17");
        participante2.put("celular", "54321");
        participante2.put("grupo sanguineo", "o-");
        participante2.put("categoria", "circuito medio");

        Map<String, String> participante3 = new LinkedHashMap<>();
        participante3.put("dni", "3");
        participante3.put("nombre", "Alberto Perez");
        participante3.put("edad", "16");
        participante3.put("celular", "98765");
        participante3.put("grupo sanguineo", "A+");
        participante3.put("categoria", "circuito Avanzado");

        /**
         * Inscripcion de Participantes en cada una de las categorias.
         */
        //Circuito Chico
        List<Map<String, String>> inscritosCircuitoChico = new ArrayList<>();
        inscritosCircuitoChico.add(participante1);

        for (Map<String, String> inscrito : inscritosCircuitoChico) {
            System.out.println("Inscribiendo al participante " + inscrito + "En la lista Circuito Chico" + "\n");
        }


        //Circuito Medio
        List<Map<String, String>> inscritosCircuitoMedio = new ArrayList<>();
        inscritosCircuitoMedio.add(participante2);

        for (Map<String, String> inscrito : inscritosCircuitoMedio) {
            System.out.println("Inscribiendo al participante " + inscrito + "En la lista Circuito Medio" + "\n");
        }

        //Circuito Avanzado
        List<Map<String, String>> inscritosCircuitoAvanzado = new ArrayList<>();
        inscritosCircuitoAvanzado.add(participante3);

        for (Map<String, String> inscrito : inscritosCircuitoAvanzado) {
            System.out.println("Inscribiendo al participante " + inscrito + "En la lista Circuito Avanzado" + "\n");
        }

        /**
         * Retirando a un participante de la categoria Media
         */
        System.out.println("Participante Inscritos en la categoria Medio " + inscritosCircuitoMedio.size());
        //inscritosCircuitoMedio.remove(0);
        //System.out.println("Un Participante descalificado");
        System.out.println("Participantes Inscritos en la categoria Medio " + inscritosCircuitoMedio.size() + "\n");

        /**
         * Ejecucion del metodo
         */
        System.out.println(calculandoMonto(inscritosCircuitoChico));
        System.out.println(calculandoMonto(inscritosCircuitoMedio));
        System.out.println(calculandoMonto(inscritosCircuitoAvanzado));

    }

    /**
     * Calculando el monto del participante segun su inscripcion.
     */
    public static String calculandoMonto(List<Map<String, String>> listaDeInscritos) {

        String montoParticipante = "No hay participantes Inscritos" + "\n";

        if (!listaDeInscritos.isEmpty()) {

            for (Map inscrito : listaDeInscritos) {

                String participante = (String) inscrito.get("nombre");
                int valorEdad = Integer.parseInt((String) inscrito.get("edad"));
                //int valorEdad = Integer.valueOf( (String) inscrito.get("edad"));
                String nombreDelCircuito = (String) inscrito.get("categoria");

                if (valorEdad < 18) {

                    switch (nombreDelCircuito) {
                        case "circuito chico":
                            montoParticipante = "Costo Inscripcion del participante " + participante + " $1300.0" + "\n";
                            break;
                        case "circuito medio":
                            montoParticipante = "Costo Inscripcion del participante " + participante + " $2000.0" + "\n";
                            break;
                        case "circuito Avanzado":
                            montoParticipante = "No se permite participantes menores de 18 años" + "\n";
                            break;
                    }

                } else {

                    switch (nombreDelCircuito) {
                        case "circuito chico":
                            montoParticipante = "Costo Inscripcion del participante " + participante + " $1500.0" + "\n";
                            break;
                        case "circuito medio":
                            montoParticipante = "Costo Inscripcion del participante " + participante + " $2300.0" + "\n";
                            break;
                        case "circuito Avanzado":
                            montoParticipante = "Costo Inscripcion del participante " + participante + " $2800.0" + "\n";
                            break;
                    }
                }
            }

        }

        return montoParticipante;
    }


}
