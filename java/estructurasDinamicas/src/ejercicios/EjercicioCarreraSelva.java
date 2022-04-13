package ejercicios;

/*
Carrera de la Selva
Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como
“Carrera de la Selva”. El mismo se trata de una competición donde los mejores maratonistas y corredores de
Latinoamérica se reúnen para desafiar sus habilidades deportivas.

La competencia cuenta con 3 categorías dependiendo de su dificultad:
    - Circuito chico: 2 km por selva y arroyos.
    - Circuito medio: 5 km por selva, arroyos y barro.
    - Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.

Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar
los siguientes datos: dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
A cada inscripto, a la vez, se le asigna un número de participante consecutivo con respecto a la inscripción anterior;
por ejemplo, si un participante se inscribe y el anterior fue el número 36, se le va a asignar el número 37.

Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen en
cuenta los siguientes valores:

    - Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
    - Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
    - Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que
sea capaz de:

    a) Inscribir a un nuevo participante en una categoría. (Tener en cuenta que cada categoría tiene una lista de
    inscriptos diferente).
    b) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número
    de inscripción.
    c) Desinscribir a un participante de una categoría.
    d) Determinar el monto que deberá abonar cada participante al inscribirse. Por ejemplo: si el participante se
    inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EjercicioCarreraSelva {

    static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> circuitoChico = new ArrayList<>();
        ArrayList<HashMap<String, Object>> circuitoMedio = new ArrayList<>();
        ArrayList<HashMap<String, Object>> circuitoAvanzado = new ArrayList<>();
        int conteoInscriptos = 0;
        boolean inscripto = false;

        int opcion;
        System.out.println("Bienvenido/a a la aplicación de Carrera de la Selva!");

        do {
            System.out.println("Menu:");
            System.out.println("1) Inscribir un nuevo participante en una categoía.");
            System.out.println("2) Mostrar inscriptos por categoría.");
            System.out.println("3) Desinscribir participante de una categoría.");
            System.out.println("4) Cerrar la aplicación.");
            System.out.println("Ingrese la opción deseada, por favor: ");
            opcion = Integer.parseInt(teclado.nextLine());


            switch(opcion) {
                case 1:
                    inscripto = inscribirParticipante(circuitoChico, circuitoMedio, circuitoAvanzado, conteoInscriptos);

                    if (inscripto)
                        conteoInscriptos++;
                        
                    break;
                case 2:
                    mostrarInscriptos(circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;
                case 3: desinscribirParticipante(circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;
                case 4:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("La opción no corresponde a una valida, por favor elija nuevamente.");
                    break;
            }
        } while (opcion != 4);

        teclado.close();
    }

    private static void desinscribirParticipante(ArrayList<HashMap<String, Object>> circuitoChico,
                                          ArrayList<HashMap<String, Object>> circuitoMedio,
                                          ArrayList<HashMap<String, Object>> circuitoAvanzado) {
        int cat;

        System.out.println("Elija el circuito para desinscribir un participante: ");
        System.out.println("1) Circuito chico.");
        System.out.println("2) Circuito medio.");
        System.out.println("3) Circuito Avanzado.");
        cat = Integer.parseInt(teclado.nextLine());
        int posicion;
        String dni;
        do {
            switch (cat) {
                case 1:
                    System.out.println("Ingrese el dni del participante a desinscribir: ");
                    dni = teclado.nextLine();
                    posicion = -1;
                    if (circuitoChico.size() > 0) {
                        for (int i = 0; i < circuitoChico.size(); i++) {
                            if (circuitoChico.get(i).get("dni").equals(dni)) {
                                posicion = i;
                            }
                        }
                    }

                    if (posicion != -1) {
                        circuitoChico.remove(posicion);
                        System.out.println("Se desinsribió con éxito al participante.");
                    } else {
                        System.out.println("El dni no corresponde con ningún participante del circuito.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el dni del participante a desinscribir: ");
                    dni = teclado.nextLine();
                    posicion = -1;
                    if (circuitoMedio.size() > 0) {
                        for (int i = 0; i < circuitoMedio.size(); i++) {
                            if (circuitoMedio.get(i).get("dni").equals(dni)) {
                                posicion = i;
                            }
                        }
                    }

                    if (posicion != -1) {
                        circuitoMedio.remove(posicion);
                        System.out.println("Se desinsribió con éxito al participante.");
                    } else {
                        System.out.println("El dni no corresponde con ningún participante del circuito.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el dni del participante a desinscribir: ");
                    dni = teclado.nextLine();
                    posicion = -1;
                    if (circuitoAvanzado.size() > 0) {
                        for (int i = 0; i < circuitoMedio.size(); i++) {
                            if (circuitoAvanzado.get(i).get("dni").equals(dni)) {
                                posicion = i;
                            }
                        }
                    }

                    if (posicion != -1) {
                        circuitoAvanzado.remove(posicion);
                        System.out.println("Se desinsribió con éxito al participante.");
                    } else {
                        System.out.println("El dni no corresponde con ningún participante del circuito.");
                    }
                    break;
                default:
                    System.out.println("Categoría invalida, por favor elija nuevamente.");
                    break;
            }
        } while (cat < 1 && cat > 3);
    }

    private static void mostrarInscriptos(ArrayList<HashMap<String, Object>> circuitoChico,
                                              ArrayList<HashMap<String, Object>> circuitoMedio,
                                              ArrayList<HashMap<String, Object>> circuitoAvanzado) {
        int cat;

        System.out.println("Elija el circuito para mostrar la información de sus inscriptos: ");
        System.out.println("1) Circuito chico.");
        System.out.println("2) Circuito medio.");
        System.out.println("3) Circuito Avanzado.");
        cat = Integer.parseInt(teclado.nextLine());
        do {
            switch (cat) {
                case 1:
                    for (HashMap<String, Object> participante : circuitoChico) {
                        System.out.println(participante);
                    }
                    break;
                case 2:
                    for (HashMap<String, Object> participante : circuitoMedio) {
                        System.out.println(participante);
                    }
                    break;
                case 3:
                    for (HashMap<String, Object> participante : circuitoAvanzado) {
                        System.out.println(participante);
                    }
                    break;
                default:
                    System.out.println("Categoría invalida, por favor elija nuevamente.");
                    break;
            }
        } while (cat < 1 && cat > 3);
    }

    private static boolean inscribirParticipante(ArrayList<HashMap<String, Object>> circuitoChico,
                                              ArrayList<HashMap<String, Object>> circuitoMedio,
                                              ArrayList<HashMap<String, Object>> circuitoAvanzado,
                                              int conteoInscriptos) {
        int cat;
        boolean inscripto = false;

        System.out.println("Elija la categoría del participante: ");
        System.out.println("1) Circuito chico.");
        System.out.println("2) Circuito medio.");
        System.out.println("3) Circuito Avanzado.");
        cat = Integer.parseInt(teclado.nextLine());

        HashMap<String, Object> participante;
        do {
            switch (cat) {
                case 1:
                    participante = ingresarDatosParticipante();
                    if (Integer.parseInt(participante.get("edad").toString()) < 18) {
                        conteoInscriptos++;
                        participante.put("nroParticipante", conteoInscriptos);
                        participante.put("montoAbonar", 1300);
                        System.out.println("El monto que debera abonar el participante es $" + 1300);
                        circuitoChico.add(participante);
                        inscripto = true;
                    } else {
                        conteoInscriptos++;
                        participante.put("nroParticipante", conteoInscriptos);
                        participante.put("montoAbonar", 1500);
                        System.out.println("El monto que debera abonar el participante es $" + 1500);
                        circuitoChico.add(participante);
                        inscripto = true;
                    }
                    break;
                case 2:
                    participante = ingresarDatosParticipante();
                    if (Integer.parseInt(participante.get("edad").toString()) < 18) {
                        conteoInscriptos++;
                        participante.put("nroParticipante", conteoInscriptos);
                        participante.put("montoAbonar", 2000);
                        System.out.println("El monto que debera abonar el participante es $" + 2000);
                        circuitoMedio.add(participante);
                        inscripto = true;
                    } else {
                        conteoInscriptos++;
                        participante.put("nroParticipante", conteoInscriptos);
                        participante.put("montoAbonar", 2300);
                        System.out.println("El monto que debera abonar el participante es $" + 2300);
                        circuitoMedio.add(participante);
                        inscripto = true;
                    }
                    break;
                case 3:
                    participante = ingresarDatosParticipante();
                    if (Integer.parseInt(participante.get("edad").toString()) < 18) {
                        System.out.println("Los menores de 18 años no pueden participar del circuito avanzado");
                        inscripto = false;
                    } else {
                        conteoInscriptos++;
                        participante.put("nroParticipante", conteoInscriptos);
                        participante.put("montoAbonar", 2800);
                        System.out.println("El monto que debera abonar el participante es $" + 2800);
                        circuitoAvanzado.add(participante);
                        inscripto = true;
                    }
                    break;
                default:
                    System.out.println("Categoría invalida, por favor elija nuevamente.");
                    inscripto = false;
                    break;
            }
        } while (cat < 1 && cat > 3);

        return inscripto;
    }

    public static HashMap<String, Object> ingresarDatosParticipante() {
        HashMap<String, Object> participante = new HashMap<>();

        System.out.println("Ingrese el dni del participante: ");
        String dni = teclado.nextLine();
        participante.put("dni", dni);

        System.out.println("Ingrese el nombre del participante: ");
        String nombre = teclado.nextLine();
        participante.put("nombre", nombre);

        System.out.println("Ingrese el apellido del participante: ");
        String apellido = teclado.nextLine();
        participante.put("apellido", apellido);

        System.out.println("Ingrese la edad del participante: ");
        int edad = Integer.parseInt(teclado.nextLine());
        participante.put("edad", edad);

        System.out.println("Ingrese el celular del participante: ");
        int celular = Integer.parseInt(teclado.nextLine());
        participante.put("celular", celular);

        System.out.println("Ingrese el número de emergencia del participante: ");
        int nroEmergencia = Integer.parseInt(teclado.nextLine());
        participante.put("nroEmergencia", nroEmergencia);

        System.out.println("Ingrese el grupo sanguineo del participante: ");
        String grupoSanguineo = teclado.nextLine();
        participante.put("grupoSanguineo", grupoSanguineo);

        return participante;
    }
}
