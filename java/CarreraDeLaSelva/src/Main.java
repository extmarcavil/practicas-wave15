import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer,String> listaPersonasChico = new HashMap<>();
        Map<Integer,String> listaPersonasMedio = new HashMap<>();
        Map<Integer,String> listaPersonasAvanzado = new HashMap<>();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        int nroParticipante = 1;

        while (opcion != 4) {
            System.out.println("1.Inscribir participante \n2.Mostrar participantes \n3.Desinscribir participante \n4.Salir\nIngrese la opcion que desee: ");
            opcion = teclado.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el dni del participante: ");
                    var dni = teclado.nextInt();
                    System.out.println("Ingrese el nombre del participante: ");
                    var nombre = teclado.next();
                    System.out.println("Ingrese el apellido del participante: ");
                    var apellido = teclado.next();
                    System.out.println("Ingrese la edad del participante: ");
                    var edad = teclado.nextInt();
                    System.out.println("Ingrese el celular del participante: ");
                    var celular = teclado.next();
                    System.out.println("Ingrese un numero de emergencia: ");
                    var nroEmergencia = teclado.next();
                    System.out.println("Ingrese grupo sanguineo: ");
                    var grupoSanguineo = teclado.next();
                    var datosCompletos = dni + ", " + nombre + ", " + apellido + ", " + edad + ", " + celular + ", " + nroEmergencia + ", " + grupoSanguineo;
                    //Ahora tendria que preguntar en que categoria y dependiendo la categoria, agregar los datos al diccionario
                    System.out.println("\n1.Circuito chico \n2.Circuito medio \n3.Circuito avanzado \nSeleccione la categoria que desee: ");
                    var categoria = teclado.nextInt();
                    switch (categoria){
                        case 1:
                            listaPersonasChico.put(nroParticipante,datosCompletos);
                            if(edad < 18){
                                System.out.println("Debe abonar $1300\n\n");
                            }
                            if (edad > 18){
                                System.out.println("Debe abonar $1500\n\n");
                            }
                            break;
                        case 2:
                            listaPersonasMedio.put(nroParticipante,datosCompletos);
                            if(edad < 18){
                                System.out.println("Debe abonar $2000\n\n");
                            }
                            if (edad > 18){
                                System.out.println("Debe abonar $2300\n\n");
                            }
                            break;
                        case 3:
                            listaPersonasAvanzado.put(nroParticipante,datosCompletos);
                            if(edad < 18){
                                System.out.println("No se pueden inscribir menores en esta categoria");
                                return;
                            }
                            if (edad > 18){
                                System.out.println("Debe abonar $2800\n\n");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n\nLos inscriptos en el circuito chico:");
                    for (Map.Entry<Integer, String> entrada : listaPersonasChico.entrySet()){
                        System.out.println("Numero de inscripto: " + entrada.getKey() + " Datos = " + entrada.getValue());
                    }
                    System.out.println("\n\nLos inscriptos en el circuito medio:");
                    for (Map.Entry<Integer, String> entrada : listaPersonasMedio.entrySet()){
                        System.out.println("Numero de inscripto: " + entrada.getKey() + " Datos = " + entrada.getValue());
                    }
                    System.out.println("\n\nLos inscriptos en el circuito avanzado:");
                    for (Map.Entry<Integer, String> entrada : listaPersonasAvanzado.entrySet()){
                        System.out.println("Numero de inscripto: " + entrada.getKey() + " Datos = " + entrada.getValue());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Ingrese el numero de participante a remover: ");
                        var participanteRemover = teclado.nextInt();
                        System.out.println("1.Circuito chico \n2.Circuito medio \n3.Circuito avanzado \nSeleccione la categoria: ");
                        var categoriaRemover = teclado.nextInt();
                        switch (categoriaRemover){
                            case 1:
                                listaPersonasChico.remove(participanteRemover);
                                System.out.println("El participante fue removido con exito");
                                break;
                            case 2:
                                listaPersonasMedio.remove(participanteRemover);
                                System.out.println("El participante fue removido con exito");
                                break;
                            case 3:
                                listaPersonasAvanzado.remove(participanteRemover);
                                System.out.println("El participante fue removido con exito");
                                break;
                        }
                    }
                    catch (Exception ex){
                        System.out.println("No se encontro el partipante que se deseaba remover");
                        return;
                    }
            }


        }


    }
}
