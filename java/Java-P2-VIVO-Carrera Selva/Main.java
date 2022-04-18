package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static ArrayList<Inscripcion> listaInscripciones= new ArrayList<>();

    public static void main(String[] args) {

        int opcionPrincipalElegida = 0;

        while(opcionPrincipalElegida == 0){
            System.out.println("****************************************");
            System.out.println(" **** Ingrese una opcion: **** \n" );
            System.out.println(" 1 - Inscribir un participante ");
            System.out.println(" 2 - Listar todos los participantes ");
            System.out.println(" 3 - Desinscribir un participante ");
            System.out.println(" 4 - Calcular monto de un participante ");
            System.out.println(" 9 - Salir ");
            System.out.println("****************************************");

            Scanner teclado = new Scanner(System.in);
            opcionPrincipalElegida = teclado.nextInt();

            if (opcionPrincipalElegida == 9) {
                System.out.println("****************************************");
                System.out.println("*** Gracias por utilizar el sistema ****");
                System.out.println("****************************************");
                break;
            }

            switch(opcionPrincipalElegida){
                case 1 : inscribirParticipante();
                         opcionPrincipalElegida = 0;
                         break;
                case 2 : listarInscripciones();
                         opcionPrincipalElegida = 0;
                         break;
                case 3 : desInscribirParticipante();
                         opcionPrincipalElegida = 0;
                         break;
                case 4 : mostrarMontoParticipante();
                         opcionPrincipalElegida = 0;
                         break;
                default:
                    System.out.println("Debe Ingresar una opcion de 1 a 4");
                    opcionPrincipalElegida = 0;
                    break;
            }
        }
    }

    // OPCION 1
    public static void inscribirParticipante(){
        boolean flagError = false;
        System.out.println("** Ingrese los datos del Participante. ** ");

        Scanner teclado = new Scanner(System.in);
        System.out.println("* DNI: ");
        String dni = teclado.next();

        System.out.println("* Nombre: ");
        String nombre = teclado.next();

        System.out.println("* Apellido: ");
        String apellido = teclado.next();

        System.out.println("* Edad: ");
        int edad = teclado.nextInt();

        System.out.println("* Celular: ");
        String celular = teclado.next();

        System.out.println("* Nro. de Emergencia: ");
        String nroEmergencia = teclado.next();

        System.out.println("* Grupo Sanguineo: ");
        String grupoSanguineo = teclado.next();

        Participante participante = new Participante(dni, nombre, apellido, edad, celular, nroEmergencia, grupoSanguineo);

        System.out.println("** Ingrese la categoria (chico/medio/avanzado) ** ");
        String categoriaParametro = teclado.next();

        Categoria categoria = new Categoria(categoriaParametro);

        if(categoria.verificoCategoria(categoriaParametro)){
            System.out.println("** Categoria No Permitida");
            flagError = true;
        }

        if (participante.getEdad() < 18 && categoria.getCircuito() == "avanzado"){
            System.out.println("** No esta permitida la inscripcion para menores de 18 años al circuito avanzado");
            flagError = true;
        }

        if (!flagError){
            Inscripcion inscripcion = new Inscripcion(participante, categoria);
            listaInscripciones.add(inscripcion);

            System.out.println("** Felicidades! El participante fue inscripto correctamente! ** \b ");
        }
    }

    // OPCION 2.
    public static void listarInscripciones(){
          for(int i = 0; i < listaInscripciones.size(); i++) {
              float monto = calcularMonto(listaInscripciones.get(i).getNroInscripto());
              NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("mx","AR"));
              System.out.println("Nro de Inscripcion: " + listaInscripciones.get(i).getNroInscripto() + "\b" +
                      "- Datos del Participante: " + listaInscripciones.get(i).getParticipante().toString() + "\b" +
                      "- Monto a abonar: " + formatoImporte.format(monto) + "\b");

          }
    }

    // OPCION 3
    public static void desInscribirParticipante(){
        System.out.println("** Ingrese el nro de Inscripcion o el DNI del Participante ** ");
        Scanner teclado = new Scanner(System.in);
        int datoIngresado = teclado.nextInt();
        boolean flagEncontrado = false;

        for(int i = 0; i < listaInscripciones.size();i++){
            if (listaInscripciones.get(i).getNroInscripto() == datoIngresado || listaInscripciones.get(i).getParticipante().getDni().equals(Integer.toString(datoIngresado)) ){
                listaInscripciones.remove(i);
                flagEncontrado = true;
                break;
            }
        }

        if(flagEncontrado){
            System.out.println("** Participante desInscripto correctamente ** ");
        }else{
            System.out.println("**Error** Participante no encontrado en la lista de Participantes");
        }
    }

    // OPCION 4
    public static void mostrarMontoParticipante(){
        System.out.println("** Ingrese el nro de Inscripcion o el DNI del Participante ** ");
        Scanner teclado = new Scanner(System.in);
        int datoIngresado = teclado.nextInt();
        boolean flagEncontrado = false;
        Participante participante = new Participante();
        float monto = 0;

        for(int i = 0; i < listaInscripciones.size(); i++){
            if (listaInscripciones.get(i).getNroInscripto() == datoIngresado || listaInscripciones.get(i).getParticipante().getDni().equals(Integer.toString(datoIngresado))){
                int nroInscr = listaInscripciones.get(i).getNroInscripto();
                monto = calcularMonto(nroInscr);
                participante = listaInscripciones.get(i).getParticipante();
                flagEncontrado = true;
                break;
            }
        }

        if (flagEncontrado){
            NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("mx","AR"));
            System.out.println("El monto del participante: " + participante.getNombre() + " " + participante.getApellido() + " es de: " + formatoImporte.format(monto));
        }else{
            System.out.println("**Error** Participante no encontrado");
        }
    }

    public static float calcularMonto(int nroInscripcion){
        Inscripcion inscripcion = buscoInscripcion(nroInscripcion);

        if (inscripcion == null){
            System.out.println("No se encontro ningun inscripto con ese numero");
            return 0;
        }else {
            int monto = 0;
            int edad = inscripcion.getParticipante().getEdad();
            String cate = inscripcion.getCategoria().getCircuito();
            cate.toLowerCase();

            switch (cate) {
                case "chico":
                    if (edad < 18)
                        monto = 1300;
                    if (edad >= 18)
                        monto = 1500;
                case "medio":
                    if (edad < 18)
                        monto = 2000;
                    if (edad >= 18)
                        monto = 2300;
                case "avanzado":
                    if (edad >= 18)
                        monto = 2800;
            }
            return monto;
        }
    }

    public static Inscripcion buscoInscripcion(int nroInscripcion){
       for(int i = 0; i < listaInscripciones.size(); i++){
           if (listaInscripciones.get(i).getNroInscripto() == nroInscripcion){
               return listaInscripciones.get(i);
           }
       }
        return null;
    }
}
