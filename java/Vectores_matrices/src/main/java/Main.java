import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vectores vectores = new Vectores();

        int opcion;
        do {
            System.out.println("Menú");
            System.out.println("---------------");
            System.out.println("Opción 1 Carga Ciudades");
            System.out.println("---------------");
            System.out.println("Opción 2 Carga Temperaturas");
            System.out.println("---------------");
            System.out.println("Opción 3 Listado ");
            System.out.println("---------------");
            System.out.println("Opción 0 Salir ");

            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Carga de ciudades: ");
                    System.out.println("----------------");
                    vectores.cargaCiudad();
                    System.out.println("Carga efectuada");
                    break;
                case 2:
                    System.out.println("Carga de Temperaturas: ");
                    System.out.println("----------------");
                    vectores.cargaTemperaturas();
                    System.out.println("Carga efectuada");
                    break;
                case 3:
                    System.out.println("Listado de ciudades y temperaturas");
                    System.out.println("--------------------");
                    vectores.imprimir();

                    break;
                default:
                    System.out.println("Opción invalida");
            }
        } while (opcion != 0);


    }
}
