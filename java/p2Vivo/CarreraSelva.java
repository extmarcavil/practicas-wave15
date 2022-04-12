package p2Vivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CarreraSelva {

    public static int calcularMonto (int tipoCarrera, int edad){
        return 1;
    }

    public static void agregarPersona(){

    }

    public static void main(String[] args) {
        int nextVal=1;
        ArrayList<Integer> carreraBase = new ArrayList<>();
        ArrayList<Integer> carreraMedia = new ArrayList<>();
        ArrayList<Integer> carreraAvanzada = new ArrayList<>();
        HashMap <Integer, String[]> mapa = new HashMap<>();
        HashMap<Integer, Integer> chequeoCedulas = new HashMap<>();

        boolean quit = false;
        int opcion=0;
        final Scanner teclado = new Scanner(System.in);
        while (!quit){
            System.out.println("Ingrese la opcion que desea ejecutar:\n0: Salir\n1:Agregar inscripto\n2:Mostrar inscriptos a carrera\n3:Borrar inscripto\n4:Calcular coste"); //columna
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion){
                case 0://Salir
                 quit = true;

                 break;
                case 1://Agrego persona
                    System.out.print("Ingrese el documento de la persona a agregar: ");
                    int documento = Integer.parseInt(teclado.nextLine());
                    System.out.println(documento);
                    if (chequeoCedulas.containsKey(documento)){
                        System.out.println("Ese usuario ya se ha inscripto a la carrera.");
                    }else{
                        //Lo inscribo
                        System.out.print("Ingrese a que carrera quiere inscribirse (0: basica, 1: intermedia, 2: avanzada):");
                        int carrera = Integer.parseInt(teclado.nextLine());
                        System.out.print("Ingrese su edad:");
                        int edad = Integer.parseInt(teclado.nextLine());
                        if (carrera==2 && edad<18){
                            System.out.println("Lo siento, por tu edad no puedes inscribirte a esta carrera");
                        }else{
                           //Le pido el resto de los datos
                            System.out.print("Ingrese su nombre completo:");
                            String nombre = teclado.nextLine();
                            System.out.print("Ingrese su emergencia:");
                            String emergencia = teclado.nextLine();
                            System.out.print("Ingrese su grupo sanguineo:");
                            String grupo = teclado.nextLine();
                            String[]datos = new String[6];
                            datos[0]= Integer.toString(carrera);
                            datos[1]= Integer.toString(documento);
                            datos[2]= Integer.toString(edad);
                            datos[3]= nombre;
                            datos[4]= emergencia;
                            datos[5]=grupo;
                            mapa.put(nextVal, datos);
                            chequeoCedulas.put(documento,nextVal);
                            switch (carrera){
                                case 0:
                                    carreraBase.add(nextVal);
                                    break;
                                case 1:
                                    carreraMedia.add(nextVal);
                                    break;
                                case 2:
                                    carreraAvanzada.add(nextVal);
                                    break;
                            }
                            nextVal++;


                        //Calculo cuanto debe pagar y le aviso:
                            String mensaje = "Inscripcion realizada con exito. Debe abonar $";
                            if (carrera==0) {
                                if (edad < 18) {
                                    mensaje += "1300";
                                } else {
                                    mensaje += "1800";
                                }
                            }else if (carrera==1){
                                if (edad < 18) {
                                    mensaje += "2000";
                                } else {
                                    mensaje += "2300";
                                }
                            }else{
                                mensaje += "2800";
                            }
                            System.out.println(mensaje);
                        }



                    }

                    break;
                case 2:
                    System.out.println("Seleccione que carrera listar: \n 0: Basica\n 1: Intermedia \n 2: Avanzada"); //columna
                    opcion = Integer.parseInt(teclado.nextLine());
                    ArrayList<Integer> lista = null;
                    boolean mostrar = true;
                    switch (opcion){
                        case 0:
                            lista = carreraBase;
                            break;
                        case 1:
                            lista = carreraMedia;
                            break;
                        case 2:
                            lista= carreraAvanzada;
                            break;
                        default:
                            mostrar = false;
                            break;
                    }
                    if (mostrar){
                        for(Integer key: lista){
                            String[] str = mapa.get(key);
                            System.out.println("numero inscripcion \t dni \t Nombre \t Emergencia \t Grupo sanguineo");
                            for (int i = 0; i<6;i++)
                                System.out.print(str[i] + "\t");
                            System.out.println();
                        }

                    }else{
                        System.out.println("Opcion invalida"); //columna

                    }

                    break;
                case 3:
                    System.out.println("Seleccione por que dato borrar: \n 1: Numero de inscripcion\n2: DNI"); //columna
                    opcion = Integer.parseInt(teclado.nextLine());
                    if (opcion==1){
                        System.out.println("Ingrese el numero de inscripcion: "); //columna
                        opcion = Integer.parseInt(teclado.nextLine());
                        String [] dato = mapa.get(opcion);
                        if (dato !=null){
                            if (Integer.parseInt(dato[0])==0) {
                                carreraBase.remove(opcion);
                            }else{
                                if (Integer.parseInt(dato[0])==1) {
                                    carreraMedia.remove(opcion);
                                }else{
                                    carreraAvanzada.remove(opcion);
                                }
                            }
                            chequeoCedulas.remove(dato[1]);
                            mapa.remove(opcion);
                        }else{
                            System.out.println("Error: No existe ese inscripto"); //columna

                        }
                    }else if (opcion ==2){
                        System.out.println("Ingrese el DNI: "); //columna
                        Integer ci = Integer.parseInt(teclado.nextLine());

                        if (chequeoCedulas.get(ci)!= null){
                            opcion = chequeoCedulas.get(ci);
                            String[] dato = mapa.get(opcion);
                            if (Integer.parseInt(dato[0])==0) {
                                carreraBase.remove(opcion);
                            }else{
                                if (Integer.parseInt(dato[0])==1) {
                                    carreraMedia.remove(opcion);
                                }else{
                                    carreraAvanzada.remove(opcion);
                                }
                            }
                            chequeoCedulas.remove(ci);
                            mapa.remove(opcion);
                        }else{
                            System.out.println("Error: No existe ese inscripto"); //columna

                        }
                    }

                default:
                    break;
            }

        }

    }
}
