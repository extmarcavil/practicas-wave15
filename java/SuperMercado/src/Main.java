import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var clienteServicio = new ClienteServicio();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){
            System.out.println("Seleccione una opcion");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    var sc = new Scanner(System.in);
                    long dni;
                    String nombre;
                    String apelLido;
                    System.out.println("Escriba DNI");
                    dni = Long.parseLong(sc.nextLine());
                    System.out.println("Escriba Nombre");
                    nombre = sc.next();
                    System.out.println("Escriba Apellido");
                    apelLido = sc.next();
                    var whereNuevo = clienteServicio.Buscar(dni);
                    if (whereNuevo == null)
                        clienteServicio.Nuevo(new Cliente(dni,nombre,apelLido));
                    else
                        System.out.println("Ya existe el dni");
                    break;
                case 2:
                    var sc2 = new Scanner(System.in);
                    long dni2;
                    System.out.println("Escriba DNI");
                    dni2 = Long.parseLong(sc2.nextLine());
                    var where = clienteServicio.Buscar(dni2);
                    if(where != null)
                        System.out.println("El cliente es " + where.toString());
                    else
                        System.out.println("El cliente no existe");

                    break;
                case 3:
                    var sc3 = new Scanner(System.in);
                    long dni3;
                    System.out.println("Escriba DNI");
                    dni3 = Long.parseLong(sc3.nextLine());
                    clienteServicio.Eliminar(dni3);
                    break;
                case 4:
                    clienteServicio.BuscarTodo().forEach(item -> {
                        System.out.println(item);
                    });
                    break;
                case 5:
                    scanner.close();
                    salir = true;
                    break;
            }
        }

    }
}
