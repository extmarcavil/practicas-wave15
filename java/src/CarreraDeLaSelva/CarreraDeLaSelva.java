package CarreraDeLaSelva;

import java.util.*;

public class CarreraDeLaSelva {

    public static void main(String[] args) {


        Scanner inputConsola = new Scanner (System.in);
        // inputConsola.nextInt(); //ingresando datos


        int opcion;


        // Generamos lista para cada circuito, se trabajara como una cola
        List<HashMap> circuitoChico = new ArrayList<>();
        List<HashMap> circuitoMedio = new ArrayList<>();
        List<HashMap> circuitoAvanzado = new ArrayList<>();

        //Generamos un HashMap que contendra todos los datos de cada participante en dos listas para los diferentes tipos de dato

/*
        Para agregar valores en forma de arreglos al hashmap utilizamos el siguiente esquema:
        usuarios.put(new String[] {"nombre", "apellido", "A+"}, new Integer[] {1010012213, 31121231, 2123123});
*/

        // arreglo con el nombre de los campos
        String[] camposCate = {"Nombre: ", "Apellido: ", "Grupo sanguineo: "};
        String[] camposCuant = {"dni: ", "edad: ", "celular: ", "celular emergencia: ", "precio : "};

        //PRUEBAS
/*      dni         = 1094954;
        edad        = 38;
        celular     = 311764849;
        cellEme     = 31176484;
        nombre      = "Valentino";
        apellido    = "Zapata";
        grupoSanguineo = "O+";*/




        // MENU
        boolean a = true;

        while(a){
            System.out.println("MENU\nDigite el numero de la lista que desea escoger.\n1. Inscribir participante\n2. Mostrar datos de participantes de categoria\n3. Desinscribir a un participante.\n4. SALIR\n\n");

            opcion = inputConsola.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Digite: \n1. Para inscribirse en el Circuito chico\n2. Para inscribirse en el circuito medio\n3. Para inscribirse en el circuito avanzado");
                    opcion = inputConsola.nextInt();

                    System.out.println("Digite el dni");
                    int dniC         =inputConsola.nextInt();

                    System.out.println("Digite su edad");
                    int edadC        =inputConsola.nextInt();

                    System.out.println("Digite su numero de celular");
                    int celularC     =inputConsola.nextInt();

                    System.out.println("Digite el numero de celular de emergencia");
                    int cellEmeC     =inputConsola.nextInt();

                    System.out.println("Digite su nombre");
                    String nombreC   =inputConsola.next();

                    System.out.println("Digite su apellido");
                    String apellidoC    =inputConsola.next();

                    System.out.println("Digite su grupo sanguineo");
                    String grupoSanguineoC =inputConsola.next();

                    switch (opcion) {
                        case 1:
                            System.out.println("Se selecciono el circuito Chico");

                            //usuarios.put(new String[] {"Valentina", "Zapata", "A+"}, new Integer[] {1010012213, 18, 31121231, 2123123,(edad >= 18 ? 1500 : 1300)});


                            circuitoChico.add(new HashMap<String[], Integer[]>() {{
                                                  put(new String[]{nombreC, apellidoC, grupoSanguineoC}, new Integer[]{dniC, edadC, celularC, cellEmeC, (edadC >= 18 ? 1500 : 1300)});
                                              }}
                            );

                            break;

                        case 2:


                            circuitoMedio.add(new HashMap<String[], Integer[]>() {{
                                                  put(new String[]{nombreC, apellidoC, grupoSanguineoC}, new Integer[]{dniC, edadC, celularC, cellEmeC, (edadC >= 18 ? 2300 : 2000)});
                                              }}
                            );

                            break;

                        case 3:
                            System.out.println("Se selecciono el circuito Avanzado");


                            if (edadC < 18) {
                                System.out.println(" No tiene la edad suficiente para participar en el circuito avanzado");
                            } else {

                                circuitoAvanzado.add(new HashMap<String[], Integer[]>() {{
                                                         put(new String[]{nombreC, apellidoC, grupoSanguineoC}, new Integer[]{dniC, edadC, celularC, cellEmeC, 2800});
                                                     }}
                                );

                            }
                            break;

                        default:
                            System.out.println("No se escogio ninguna carrera");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Digite:\n1. para ver los participantes del circuito chico\n2. para ver los participantes del circuito medio\n3. para ver los participantes del circuito avanzado\n");
                    opcion = inputConsola.nextInt();
                    switch (opcion) {
                        case 1:
                            //Recorriendo el hashmap
                            for (HashMap user : circuitoChico) {

                                Set<Map.Entry<String[], Integer[]>> entries = user.entrySet(); // SUPER IMPORTANTE -> Obtener una colección de objetos
                                for (Map.Entry<String[], Integer[]> entry : entries) {

                                    String [] key=entry.getKey();
                                    Integer [] value=entry.getValue();

                                    //recorriendo los arreglos categoricos y cuantitativos con los datos
                                    for (int i = 0; i < key.length; i++) {
                                        System.out.println(camposCate[i] + key[i]);
                                    }
                                    for (int i = 0; i < value.length; i++) {
                                        System.out.println(camposCuant[i] + value[i]);
                                    }
                                }
                            }
                            break;
                        case 2:
                            for (HashMap user : circuitoMedio) {

                                Set<Map.Entry<String[], Integer[]>> entries=user.entrySet(); // SUPER IMPORTANTE -> Obtener una colección de objetos
                                for (Map.Entry<String[], Integer[]> entry : entries) {

                                    String [] key=entry.getKey();
                                    Integer [] value=entry.getValue();

                                    //recorriendo los arreglos categoricos y cuantitativos con los datos
                                    for (int i = 0; i < key.length; i++) {
                                        System.out.println(camposCate[i] + key[i]);
                                    }
                                    for (int i = 0; i < value.length; i++) {
                                        System.out.println(camposCuant[i] + value[i]);
                                    }
                                }
                            }
                            break;
                        case 3:
                            for (HashMap user : circuitoAvanzado) {

                                Set<Map.Entry<String[], Integer[]>> entries=user.entrySet(); // SUPER IMPORTANTE -> Obtener una colección de objetos
                                for (Map.Entry<String[], Integer[]> entry : entries) {

                                    String [] key=entry.getKey();
                                    Integer [] value=entry.getValue();

                                    //recorriendo los arreglos categoricos y cuantitativos con los datos
                                    for (int i = 0; i < key.length; i++) {
                                        System.out.println(camposCate[i] + key[i]);
                                    }
                                    for (int i = 0; i < value.length; i++) {
                                        System.out.println(camposCuant[i] + value[i]);
                                    }
                                }
                            }
                            break;
                    }

                    break;
                case 3:
                    System.out.println(" Digite la carrera a la que pertenece el participante a desinscribir:\n1. circuito chico\n2. circuito medio\n3. circuito avanzado\n");
                    opcion = inputConsola.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("Digite el numero de inscripcion del participante a borrar");
                            opcion = inputConsola.nextInt();
                            circuitoChico.remove(opcion);
                            break;
                        case 2:
                            System.out.println("Digite el numero de inscripcion del participante a borrar");
                            opcion = inputConsola.nextInt();
                            circuitoMedio.remove(opcion);
                            break;
                        case 3:
                            System.out.println("Digite el numero de inscripcion del participante a borrar");
                            opcion = inputConsola.nextInt();
                            circuitoAvanzado.remove(opcion);
                            break;

                    }

                    break;
                case 4:

                    System.out.println("Cerrando aplicación");
                    a=false;
                    break;
            }


        }
        // Cerrando Scaneer
        inputConsola.close();
    }
}
