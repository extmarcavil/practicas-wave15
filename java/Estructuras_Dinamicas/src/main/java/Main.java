import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> Participantes = new ArrayList<>();

        HashMap<Integer, String> Circuito_Chico = new HashMap<>();
        HashMap<Integer, String> Circuito_Mediano = new HashMap<>();
        HashMap<Integer, String> Circuito_Avanzado = new HashMap<>();

        int opcion, opcion2;
        int compedirores_Carrera = 3;
        int edad;
        int monto = 0;

        String opcion_Circuito;
        String dni;
        String nombre;
        String apellido;
        String celular;
        String numero_Emergencia;
        String grupo_Sanguineo;

        String competidor[][] = new String[compedirores_Carrera][10];

        do {
            System.out.println("Opción 1 para Ingresar Competidor");
            System.out.println("Opcion 2 para Mostrar inscritos");
            System.out.println("opcion 3 para remover inscrito");
            System.out.println("Opcion 0 para Salir del sistema");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    do {
                        System.out.println("¿Desea ingresar un competido ?");
                        System.out.println("Opcion 1: SI");
                        System.out.println("Opcion 2: NO");
                        opcion2 = Integer.parseInt(sc.nextLine());
                        switch (opcion2) {
                            case 1:
                                for (int i = 0; i < competidor.length; i++) {
                                    for (int j = 0; j < 8; j++) {

                                        System.out.println("Ingresar DNI");
                                        dni = sc.nextLine();
                                        competidor[i][j] = dni;
                                        j++;

                                        System.out.println("Ingresar Nombre");
                                        nombre = sc.nextLine();
                                        competidor[i][j] = nombre;
                                        j++;

                                        System.out.println("Ingresar apellido");
                                        apellido = sc.nextLine();
                                        competidor[i][j] = apellido;
                                        j++;

                                        System.out.println("Ingresar celular");
                                        celular = sc.nextLine();
                                        competidor[i][j] = celular;
                                        j++;

                                        System.out.println("Ingresar numero emergencia");
                                        numero_Emergencia = sc.nextLine();
                                        competidor[i][j] = numero_Emergencia;
                                        j++;

                                        System.out.println("Ingresar grupo sanguineo");
                                        grupo_Sanguineo = sc.nextLine();
                                        competidor[i][j] = grupo_Sanguineo;
                                        j++;

                                        System.out.println("Ingresar edad");
                                        edad = Integer.parseInt(sc.nextLine());
                                        competidor[i][j] = String.valueOf(edad);
                                        j++;


                                        if (edad <= 18) {
                                            int paso = 0;
                                            do {
                                                System.out.println("Ingrese el circuito a inscribirse");
                                                opcion_Circuito = sc.nextLine().toUpperCase();
                                                if (opcion_Circuito.equals(String.valueOf(categorias.CHICO))) {
                                                    monto = 1300;
                                                    Circuito_Chico.put(i, "DNI: " + dni + "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Numero Emergencia: " + numero_Emergencia + "Grupo Sanguineo: " + grupo_Sanguineo + "Edad: " + edad + "Monto: " + monto);
                                                    paso = 1;
                                                } else if (opcion_Circuito.equals(String.valueOf(categorias.MEDIANO))) {
                                                    monto = 2000;
                                                    Circuito_Mediano.put(i, "DNI: " + dni + "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Numero Emergencia: " + numero_Emergencia + "Grupo Sanguineo: " + grupo_Sanguineo + "Edad: " + edad + "Monto: " + monto);
                                                    paso = 1;
                                                }
                                            } while (paso == 0);
                                        } else {
                                            System.out.println("Ingrese el circuito a inscribirse");
                                            opcion_Circuito = sc.nextLine().toUpperCase();

                                            switch (opcion_Circuito) {
                                                case "CHICO":
                                                    monto = 1500;
                                                    Circuito_Chico.put(i, "DNI: " + dni + "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Numero Emergencia: " + numero_Emergencia + "Grupo Sanguineo: " + grupo_Sanguineo + "Edad: " + edad + "Monto: " + monto);
                                                    break;
                                                case "MEDIANO":
                                                    monto = 2300;
                                                    Circuito_Mediano.put(i, "DNI: " + dni + "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Numero Emergencia: " + numero_Emergencia + "Grupo Sanguineo: " + grupo_Sanguineo + "Edad: " + edad + "Monto: " + monto);
                                                    break;

                                                case "AVANZADO":
                                                    monto = 2800;
                                                    Circuito_Avanzado.put(i, "DNI: " + dni + "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Numero Emergencia: " + numero_Emergencia + "Grupo Sanguineo: " + grupo_Sanguineo + "Edad: " + edad + "Monto: " + monto);
                                                    break;
                                            }

                                        }
                                        competidor[i][j] = opcion_Circuito;
                                        System.out.println("Monto Inscripcion: " + monto);
                                        j++;
                                    }

                                }
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    } while (opcion2 != 0);
                    break;
                case 2:
                    System.out.println(Circuito_Chico);
                    System.out.println(Circuito_Mediano);
                    System.out.println(Circuito_Avanzado);
                    break;
                case 3:

                    System.out.println("Competicion ?");
                    opcion_Circuito = sc.nextLine().toUpperCase();

                    int removedor;
                    int llave;

                    String valor;
                    switch (opcion_Circuito) {
                        case "CHICO":
                            System.out.println("Participante a eliminar");
                            removedor = Integer.parseInt(sc.nextLine());

                            for (Map.Entry<Integer, String> entry : Circuito_Chico.entrySet()) {
                                System.out.println(Circuito_Chico);
                                llave = entry.getKey();
                                valor = entry.getValue();
                                if(removedor==llave){
                                    Circuito_Chico.remove(llave,valor);
                                }
                            }
                            break;
                        case "MEDIANO":
                            System.out.println("Participante a eliminar");
                            removedor = Integer.parseInt(sc.nextLine());

                            for (Map.Entry<Integer, String> entry : Circuito_Mediano.entrySet()) {
                                System.out.println(Circuito_Mediano);
                                llave = entry.getKey();
                                valor = entry.getValue();
                                if(removedor==llave){
                                    Circuito_Mediano.remove(llave,valor);
                                }
                            }
                            break;
                        case "AVANZADO":
                            System.out.println("Participante a eliminar");
                            removedor = Integer.parseInt(sc.nextLine());

                            for (Map.Entry<Integer, String> entry : Circuito_Avanzado.entrySet()) {
                                System.out.println(Circuito_Avanzado);
                                llave = entry.getKey();
                                valor = entry.getValue();
                                if(removedor==llave){
                                    Circuito_Avanzado.remove(llave,valor);
                                }
                            }
                            break;
                    }
                    break;
            }
        } while (opcion != 0);

    }

    public enum categorias {
        CHICO, MEDIANO, AVANZADO
    }

}

