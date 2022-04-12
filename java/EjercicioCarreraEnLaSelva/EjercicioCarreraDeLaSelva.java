package EjercicioCarreraEnLaSelva;

import java.lang.reflect.Array;
import java.util.*;

public class EjercicioCarreraDeLaSelva {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Scanner ingresoDeDatos = new Scanner(System.in);
        int opcion=0;
        int opcion2=0;
        int contador =0;

        ArrayList<Integer> numeroDeInscripcion = new ArrayList<Integer>();
        ArrayList<String> dni = new ArrayList<String>();
        ArrayList<String> nombre = new ArrayList<String>();
        ArrayList<String> apellido = new ArrayList<String>();
        ArrayList<Integer> edad = new ArrayList<Integer>();
        ArrayList<Integer> celular = new ArrayList<Integer>();
        ArrayList<Integer> numeroDeEmergencia = new ArrayList<Integer>();
        ArrayList<String> grupoSanguineo = new ArrayList<String>();
        ArrayList<Integer> categoria = new ArrayList<Integer>();


        System.out.println("Ingrese la opcion que desea realizar");
        do{
            System.out.println("1: Inscribir a un nuevo participante en una categoría");
            System.out.println("2: Ver a los inscritos a una determinada categoría con sus correspondientes datos y número de inscripción.");
            System.out.println("3: Desinscribir a un participante de una categoría.");
            System.out.println("4: Determinar el monto que deberá abonar cada participante al inscribirse.");
            System.out.println("5: Salir");
            opcion = teclado.nextInt();
            opcion2=0;
            switch (opcion){
                case 1:

                    contador = contador +1;
                    numeroDeInscripcion.add(contador);
                    System.out.println("Selecciono: Inscribir a un nuevo participante en una categoría");
                    System.out.println("Ingrese DNI");
                    dni.add(ingresoDeDatos.next());
                    System.out.println("Ingrese Nombre");
                    nombre.add(ingresoDeDatos.next());
                    System.out.println("Ingrese Apellido");
                    apellido.add(ingresoDeDatos.next());
                    System.out.println("Ingrese Edad");
                    edad.add(ingresoDeDatos.nextInt());
                    System.out.println("Ingrese Celular");
                    celular.add(ingresoDeDatos.nextInt());
                    System.out.println("Ingrese Numero de Emergencia");
                    numeroDeEmergencia.add(ingresoDeDatos.nextInt());
                    System.out.println("Ingrese Grupo Sanguineo");
                    grupoSanguineo.add(ingresoDeDatos.next());
                    System.out.println("Seleccione la categoria (numero)");
                    System.out.println("1: Circuito Chico");
                    System.out.println("2: Circuito Medio");
                    System.out.println("3: Circuito Avanzado");
                    categoria.add(ingresoDeDatos.nextInt());
                    System.out.println("Datos ingresados Correctamente");
                    System.out.println("-------------------------------");

                    break;
                case 2:

                    System.out.println("Selecciono: Ver los inscritos a una determinada categoría con sus correspondientes datos y número de inscripción.");
                    System.out.println("(presione 6 para volver)");
                    System.out.println("Seleccione la categoria");
                    System.out.println("1: Circuito Chico");
                    System.out.println("2: Circuito Medio");
                    System.out.println("3: Circuito Avanzado");
                    opcion2 = teclado.nextInt();
                    if (opcion2 == 1){
                        for (int j=0; j <categoria.size(); j++){
                            numeroDeInscripcion.get(j);
                            dni.get(j);
                            nombre.get(j);
                            apellido.get(j);
                            edad.get(j);
                            celular.get(j);
                            numeroDeEmergencia.get(j);
                            grupoSanguineo.get(j);

                            int cat = categoria.get(j);
                            if (cat == 1){
                                System.out.println(numeroDeInscripcion.get(j)+" "+dni.get(j)+" "+nombre.get(j)+" "+apellido.get(j)+" "+edad.get(j)+" "+celular.get(j)+" "+numeroDeEmergencia.get(j)+" "+grupoSanguineo.get(j)+" "+cat);
                            }
                        }
                    }else if(opcion2 == 2){
                        for (int k=0; k <categoria.size(); k++){
                            numeroDeInscripcion.get(k);
                            dni.get(k);
                            nombre.get(k);
                            apellido.get(k);
                            edad.get(k);
                            celular.get(k);
                            numeroDeEmergencia.get(k);
                            grupoSanguineo.get(k);

                            int cat = categoria.get(k);
                            if (cat == 2){
                                System.out.println(numeroDeInscripcion.get(k)+" "+dni.get(k)+" "+nombre.get(k)+" "+apellido.get(k)+" "+edad.get(k)+" "+celular.get(k)+" "+numeroDeEmergencia.get(k)+" "+grupoSanguineo.get(k)+" "+cat);
                            }
                        }
                    }else if(opcion2 == 3){
                        for (int l=0; l <categoria.size(); l++){
                            numeroDeInscripcion.get(l);
                            dni.get(l);
                            nombre.get(l);
                            apellido.get(l);
                            edad.get(l);
                            celular.get(l);
                            numeroDeEmergencia.get(l);
                            grupoSanguineo.get(l);

                            int cat = categoria.get(l);
                            if (cat == 3){
                                System.out.println(numeroDeInscripcion.get(l)+" "+dni.get(l)+" "+nombre.get(l)+" "+apellido.get(l)+" "+edad.get(l)+" "+celular.get(l)+" "+numeroDeEmergencia.get(l)+" "+grupoSanguineo.get(l)+" "+cat);
                            }
                        }
                    }
                    break;
                case 3:

                    System.out.println("Selecciono: Desinscribir a un participante de una categoría.");
                    for (int j=0; j <numeroDeInscripcion.size(); j++){
                        int numDeIns = numeroDeInscripcion.get(j);
                        dni.get(j);
                        nombre.get(j);
                        apellido.get(j);
                        edad.get(j);
                        celular.get(j);
                        numeroDeEmergencia.get(j);
                        grupoSanguineo.get(j);
                        categoria.get(j);
                        System.out.println(numDeIns+" "+dni.get(j)+" "+nombre.get(j)+" "+apellido.get(j)+" "+edad.get(j)+" "+celular.get(j)+" "+numeroDeEmergencia.get(j)+" "+grupoSanguineo.get(j)+" "+categoria.get(j));
                    }
                    System.out.println("Seleccione el numero de inscripcion del participante a desincribir");
                    int desincripcion = ingresoDeDatos.nextInt();
                    for (int j=0; j <numeroDeInscripcion.size(); j++){
                        int numDeIns = numeroDeInscripcion.get(j);
                        dni.get(j);
                        nombre.get(j);
                        apellido.get(j);
                        edad.get(j);
                        celular.get(j);
                        numeroDeEmergencia.get(j);
                        grupoSanguineo.get(j);
                        categoria.get(j);
                        if (desincripcion == numDeIns){
                            numeroDeInscripcion.remove(j);
                            dni.remove(j);
                            nombre.remove(j);
                            apellido.remove(j);
                            edad.remove(j);
                            celular.remove(j);
                            numeroDeEmergencia.remove(j);
                            grupoSanguineo.remove(j);
                            categoria.remove(j);
                        }
                    }
                    System.out.println("Participante desincrito");

                    break;
                case 4:

                    System.out.println("Determinar el monto que deberá abonar cada participante al inscribirse.");
                    for (int j=0; j <edad.size(); j++){
                        numeroDeInscripcion.get(j);
                        dni.get(j);
                        nombre.get(j);
                        apellido.get(j);
                        int suEdad = edad.get(j);
                        celular.get(j);
                        numeroDeEmergencia.get(j);
                        grupoSanguineo.get(j);
                        int cat = categoria.get(j);

                        if (suEdad < 18 && cat ==1 ){
                            System.out.println("El participante: "+nombre.get(j)+" "+apellido.get(j)+" "+"con DNI: "+dni.get(j)+ " debe pagar $1.300");
                        }else if (suEdad >= 18 && cat ==1){
                            System.out.println("El participante: "+nombre.get(j)+" "+apellido.get(j)+" "+"con DNI: "+dni.get(j)+ " debe pagar $1.500");
                        }else if(suEdad < 18 && cat ==2  ){
                            System.out.println("El participante: "+nombre.get(j)+" "+apellido.get(j)+" "+"con DNI: "+dni.get(j)+ " debe pagar $2.000");
                        }else if (suEdad >= 18 && cat ==2){
                            System.out.println("El participante: "+nombre.get(j)+" "+apellido.get(j)+" "+"con DNI: "+dni.get(j)+ " debe pagar $2.300");
                        }else if(suEdad >= 18 && cat ==3){
                            System.out.println("El participante: "+nombre.get(j)+" "+apellido.get(j)+" "+"con DNI: "+dni.get(j)+ " debe pagar $2.800");
                        }
                    }
                    break;
            }
        }while(opcion != 5);
        teclado.close();
        ingresoDeDatos.close();
    }
}
