package carreraDeLaSelva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Ejercicio carrera de la selva JAVAII
public class CarreraDeLaSelva {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<String> participante = new ArrayList<String>();
        ArrayList<String> participante2 = new ArrayList<String>();
        ArrayList<String> participante3 = new ArrayList<String>();
        ArrayList<String> participante4 = new ArrayList<String>();
        ArrayList<String> participante5 = new ArrayList<String>();
        HashMap<Integer, ArrayList> cirChico = new HashMap<Integer, ArrayList>();
        HashMap<Integer, ArrayList> cirMedio = new HashMap<Integer, ArrayList>();
        HashMap<Integer, ArrayList> cirAvanzado = new HashMap<Integer, ArrayList>();

//------------------------- Inicio: Datos de participantes en sistema --------------//
        participante.add("1111");
        participante.add("Juan");
        participante.add("Perez");
        participante.add("19");
        participante.add("1234");
        participante.add("4321");
        participante.add("B+");

        cirChico.put(1, participante);

        participante2.add("2222");
        participante2.add("Lucia");
        participante2.add("Perez");
        participante2.add("20");
        participante2.add("1234");
        participante2.add("4321");
        participante2.add("B+");

        cirChico.put(2, participante2);

        participante3.add("3333");
        participante3.add("Jose");
        participante3.add("Lopez");
        participante3.add("17");
        participante3.add("1234");
        participante3.add("4321");
        participante3.add("AB+");

        cirMedio.put(1, participante3);

        participante4.add("4444");
        participante4.add("Juana");
        participante4.add("Gomez");
        participante4.add("30");
        participante4.add("1234");
        participante4.add("4321");
        participante4.add("AB+");

        cirAvanzado.put(1, participante4);

        participante5.add("5555");
        participante5.add("Diego");
        participante5.add("Ramirez");
        participante5.add("25");
        participante5.add("1234");
        participante5.add("4321");
        participante5.add("AB+");

        cirAvanzado.put(2, participante5);

//------------------------- Fin: Datos de participantes en sistema --------------//

        System.out.println("Elegir una opcion: ");
        System.out.println("1 - Inscribir participante a circuito chico");
        System.out.println("2 - Inscribir participante a circuito medio");
        System.out.println("3 - Inscribir participante a circuito avanzado");
        System.out.println("4 - Ver participantes inscripto en circuito chico");
        System.out.println("5 - Ver participantes inscripto en circuito medio");
        System.out.println("6 - Ver participantes inscripto en circuito avanzado");
        System.out.println("7 - Desinscribir participantes inscripto en circuito chico");
        System.out.println("8 - Desinscribir participantes inscripto en circuito medio");
        System.out.println("9 - Desinscribir participantes inscripto en circuito avanzado");

        int opcion = teclado.nextInt();

        switch (opcion) {
            //inscripcion circuito chico
            case 1: {

                Boolean bandera = false;
                ArrayList<String> partNuevo = new ArrayList<String>();
                partNuevo = participante();

                System.out.println(partNuevo);

                if (cirChico.isEmpty() && cirAvanzado.isEmpty() && cirMedio.isEmpty()) {
                    cirChico.put(1, partNuevo);
                } else {
                    for (Map.Entry parti : cirChico.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirMedio.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirAvanzado.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                }
                if (bandera == false) {
                    cirChico.put(cirChico.size() + 1, partNuevo);
                    System.out.println("Se agrego el participante al circuito chico: " + cirChico);
                    //Monto que debe abonar
                    int edad = Integer.parseInt(partNuevo.get(3));
                    if (edad < 18) {
                        System.out.println("Debe abonar $1300");
                    } else {
                        System.out.println("Debe abonar $1500");
                    }
                } else {
                    System.out.println("El participante: " + partNuevo + " - No se puede inscribir");
                }
            }
            break;
            //inscripcion circuito medio
            case 2: {
                Boolean bandera = false;
                ArrayList<String> partNuevo = new ArrayList<String>();
                partNuevo = participante();

                System.out.println(partNuevo);

                if (cirChico.isEmpty() && cirAvanzado.isEmpty() && cirMedio.isEmpty()) {
                    cirMedio.put(1, partNuevo);
                } else {
                    for (Map.Entry parti : cirChico.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirMedio.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirAvanzado.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                }
                if (bandera == false) {
                    cirMedio.put(cirMedio.size() + 1, partNuevo);
                    System.out.println("Se agrego el participante al circuito medio: " + cirMedio);
                    //Monto que debe abonar
                    int edad = Integer.parseInt(partNuevo.get(3));
                    if (edad < 18) {
                        System.out.println("Debe abonar $2000");
                    } else {
                        System.out.println("Debe abonar $2300");
                    }
                } else {
                    System.out.println("El participante: " + partNuevo + " - No se puede inscribir");

                }
            }
            break;
            //inscripcion circuito avanzado
            case 3: {
                Boolean bandera = false;
                ArrayList<String> partNuevo = new ArrayList<String>();
                partNuevo = participante();

                System.out.println(partNuevo);

                if (cirChico.isEmpty() && cirAvanzado.isEmpty() && cirMedio.isEmpty()) {
                    cirMedio.put(1, partNuevo);
                } else {
                    for (Map.Entry parti : cirChico.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirMedio.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                    for (Map.Entry parti : cirAvanzado.entrySet()) {
                        ArrayList<String> p = new ArrayList<String>();
                        p = (ArrayList<String>) parti.getValue();

                        if (p.get(0).equals(partNuevo.get(0))) {
                            bandera = true;
                        }
                    }
                }
                if (bandera == false) {

                    //Monto que debe abonar
                    int edad = Integer.parseInt(partNuevo.get(3));
                    if (edad < 18) {
                        System.out.println("El participante: " + partNuevo + " - No se puede inscribir, porque es menor de edad");
                    } else {
                        cirAvanzado.put(cirAvanzado.size() + 1, partNuevo);
                        System.out.println("Se agrego el participante al circuito medio: " + cirAvanzado);
                        System.out.println("Debe abonar $2800");
                    }
                } else {
                    System.out.println("El participante: " + partNuevo + " - No se puede inscribir");
                }
            }
            break;
            //ver participantes de circuito chico
            case 4: {
                System.out.println(cirChico);
            }
            break;
            //ver participantes de circuito medio
            case 5: {
                System.out.println(cirMedio);
            }
            break;
            //ver participantes de circuito avanzado
            case 6: {
                System.out.println(cirAvanzado);
            }
            break;
            //eliminar participante del circuito chico
            case 7: {
                System.out.println("Los participantes en la categoria son: " + cirChico);
                System.out.println("Ingrese ID del participante ");
                int id = teclado.nextInt();
                cirChico.remove(id);
                System.out.println("Listado final: " + cirChico);
            }
            break;
            //eliminar participante del circuito medio
            case 8: {
                System.out.println("Los participantes en la categoria son: " + cirMedio);
                System.out.println("Ingrese ID del participante ");
                int id = teclado.nextInt();
                cirMedio.remove(id);
                System.out.println("Listado final: " + cirMedio);
            }
            break;
            //eliminar participante del circuito avanzado
            case 9: {
                System.out.println("Los participantes en la categoria son: " + cirAvanzado);
                System.out.println("Ingrese ID del participante ");
                int id = teclado.nextInt();
                cirAvanzado.remove(id);
                System.out.println("Listado final: " + cirAvanzado);
            }
            break;

        }
    }


    private static ArrayList participante() {
        Scanner entrada = new Scanner(System.in);
        String dni, nombre, apell, edad, celular, numero, gs;
        ArrayList<String> participante = new ArrayList<String>();

        System.out.println("DNI: ");
        dni = entrada.nextLine();
        participante.add(dni);
        System.out.println("Nombre: ");
        nombre = entrada.nextLine();
        participante.add(nombre);
        System.out.println("Apellido: ");
        apell = entrada.nextLine();
        participante.add(apell);
        System.out.println("Edad: ");
        edad = entrada.nextLine();
        participante.add(edad);
        System.out.println("Celular: ");
        celular = entrada.nextLine();
        participante.add(celular);
        System.out.println("Numero emerg: ");
        numero = entrada.nextLine();
        participante.add(numero);
        System.out.println("Grupo sang: ");
        gs = entrada.nextLine();
        participante.add(gs);

        return participante;
    }
}
