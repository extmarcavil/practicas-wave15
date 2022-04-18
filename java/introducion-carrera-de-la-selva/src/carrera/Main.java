package carrera;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String[]> cChico = new ArrayList<>();
        ArrayList<String[]> cMedio = new ArrayList<>();
        ArrayList<String[]> cAvanzado = new ArrayList<>();

        int opcion, categoria, codigo;

        do{
            System.out.println("Escoja una opción");
            System.out.println("1: Inscribir participante categoria Chico");
            System.out.println("2: Inscribir participante categoria Medio");
            System.out.println("3: Inscribir participante categoria Avanzado");
            System.out.println("4: Mostrar inscritos");
            System.out.println("5: Eliminar inscrito");

            opcion = scanner.nextInt();

            String[] datos;
            switch (opcion){
                case 1:
                    datos = solicitarDatos();
                    cChico.add(datos);
                    System.out.println("Monto a cancelar:");

                    if(Integer.parseInt(datos[3]) < 18 )
                        System.out.println("$1300");
                    else
                        System.out.println("$1500");
                    break;
                case 2:
                    datos = solicitarDatos();
                    cMedio.add(datos);

                    System.out.println("Monto a cancelar:");

                    if(Integer.parseInt(datos[3]) < 18 )
                        System.out.println("$2000");
                    else
                        System.out.println("$2300");
                    break;

                case 3:
                    datos = solicitarDatos();
                    cAvanzado.add(datos);

                    if(Integer.parseInt(datos[3]) < 18 ){
                        System.out.println("No se permiten menores de 18");
                        System.out.println("Eliminando registro ...");
                        cAvanzado.remove(cAvanzado.size()-1);
                    }
                    else
                        System.out.println("Monto a cancelar: $2800");

                    break;

                case 4:
                    for(String[] datosChico: cChico){
                        System.out.println("DNI: " + datosChico[0] + " Nombre: " + datosChico[1] + " Apellido: " + datosChico[2] + " Edad: " + datosChico[3] + " Celular: " + datosChico[4] + " Número de emergencia: " + datosChico[5] + " Grupo sanguíneo: " + datosChico[6]);
                    }
                    for(String[] datosMedio: cMedio){
                        System.out.println("DNI: " + datosMedio[0] + " Nombre: " + datosMedio[1] + " Apellido: " + datosMedio[2] + " Edad: " + datosMedio[3] + " Celular: " + datosMedio[4] + " Número de emergencia: " + datosMedio[5] + " Grupo sanguíneo: " + datosMedio[6]);
                    }
                    for(String[] datosAvanzado: cAvanzado){
                        System.out.println("DNI: " + datosAvanzado[0] + " Nombre: " + datosAvanzado[1] + " Apellido: " + datosAvanzado[2] + " Edad: " + datosAvanzado[3] + " Celular: " + datosAvanzado[4] + " Número de emergencia: " + datosAvanzado[5] + " Grupo sanguíneo: " + datosAvanzado[6]);
                    }
                    break;
                case 5:
                    System.out.println("Categoria");
                    System.out.println("1: Chico");
                    System.out.println("2: Medio");
                    System.out.println("3: Avanzado");

                    categoria = scanner.nextInt();

                    System.out.print("Código de inscripción: ");
                    codigo = scanner.nextInt();

                    switch (categoria){
                        case 1:
                            cChico.remove(codigo);
                        case 2:
                            cMedio.remove(codigo);
                        case 3:
                            cAvanzado.remove(codigo);
                    }
                    break;
            }

        }while (true);
    }

    static private String[] solicitarDatos(){
        Scanner scanner = new Scanner(System.in);
        String[] datos = new String[7];

        System.out.println("DNI: ");
        datos[0] = scanner.nextLine();

        System.out.println("Nombre: ");
        datos[1] = scanner.nextLine();

        System.out.println("Apellido: ");
        datos[2] = scanner.nextLine();

        System.out.println("Edad: ");
        datos[3] = scanner.nextLine();

        System.out.println("Celular: ");
        datos[4] = scanner.nextLine();

        System.out.println("Número de emergencia: ");
        datos[5] = scanner.nextLine();

        System.out.println("Grupo sanguíneo: ");
        datos[6] = scanner.nextLine();

        return datos;
    }
}
