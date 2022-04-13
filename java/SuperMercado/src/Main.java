import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var clienteServicio = new ClienteServicio();
        var facturaServicio = new FacturaServicio();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){
            System.out.println("Seleccione una opcion");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Crear Factura");
            System.out.println("6. Buscar facturas del cliente");
            System.out.println("7. Salir");

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
                    var clienteNuevo = new Cliente();
                    var listItems = new ArrayList<Producto>();
                    var scBuscar = new Scanner(System.in);
                    long dniBuscar = 0;
                    System.out.println("Favor de capturar dni,para asociar a la factura");
                    dniBuscar = Long.parseLong(scBuscar.nextLine());
                    var busqueda = clienteServicio.Buscar(dniBuscar);
                    if(busqueda == null){
                        String nombreNuevo;
                        String apellidoNuevo;
                        System.out.println("*****No existe el cliente,se dara de alta el cliente****");
                        System.out.println("Escriba Nombre");
                        nombreNuevo = scBuscar.next();
                        System.out.println("Escriba Apellido");
                        apellidoNuevo = scBuscar.next();
                        clienteServicio.Nuevo(new Cliente(dniBuscar,nombreNuevo,apellidoNuevo));
                        busqueda = clienteServicio.Buscar(dniBuscar);
                        System.out.println("Exito -->>> Se agrego el cliente");
                    }
                    int productosTotales = 0;
                    System.out.println("Agregar productos");
                    System.out.println("cuantos productos vas agregar: ");
                    scBuscar.hasNext();
                    productosTotales = Integer.parseInt(scBuscar.next());
                    //int codigo, String nombre, int cantidad, double costoUnitario
                    for (int i=0;i < productosTotales;i++){
                        System.out.println("Ingrese codigo de producto");
                        int Codigo = scBuscar.nextInt();
                        System.out.println("Ingrese nombre de producto");
                        scBuscar.hasNext();
                        String nombreProducto = scBuscar.next();
                        System.out.println("Ingrese cantidad del producto " + nombreProducto);
                        int cantidadProducto = Integer.parseInt(scBuscar.next());
                        System.out.println("Ingrese el precio del producto " + nombreProducto);
                        scBuscar.hasNext();
                        double precioProducto = Double.parseDouble(scBuscar.next());
                        listItems.add(new Producto(Codigo,nombreProducto,cantidadProducto,precioProducto));
                    }
                    facturaServicio.Nuevo(new Factura(busqueda,listItems));
                    break;
                case 6:
                    var scBuscarFacturas = new Scanner(System.in);
                    long dniBuscarFacturas = 0;
                    System.out.println("Favor de capturar dni,para buscar sus facturas");
                    dniBuscarFacturas = Long.parseLong(scBuscarFacturas.nextLine());
                    var facturas = facturaServicio.getFacturasCliente(dniBuscarFacturas);
                    System.out.println(facturas.toString());
                    System.out.println("productos");
                    facturas.forEach(item -> {
                        var p = item.getListProductos();
                        p.forEach(prod -> {
                            System.out.println("factura " + item.getCodigoFactura() + "\n"  + prod.toString());
                        });
                    });
                    break;
                case 7:
                    scanner.close();
                    salir = true;
                    break;
            }
        }

    }
}
