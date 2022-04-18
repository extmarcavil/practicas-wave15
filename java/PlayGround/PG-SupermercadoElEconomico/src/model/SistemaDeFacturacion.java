package model;

import java.util.*;

public class SistemaDeFacturacion {

    ArrayList<Factura> registroDeVentas;
    HashMap<Cliente, ArrayList<Item>> registroDeCompras;

    public SistemaDeFacturacion(List<Cliente> listaDeClientes) {
        this.registroDeVentas = new ArrayList<>();
        this.registroDeCompras = new HashMap<>();
        for (Cliente cadaCliente : listaDeClientes) {
            this.registroDeCompras.putIfAbsent(cadaCliente, new ArrayList<>());
        }
    }

    public void registrarCompra(Cliente unCliente, Item unItem, int cantidad) {
        ArrayList<Item> listaDeItemsRegistrada = this.registroDeCompras.putIfAbsent(unCliente, new ArrayList<>());
        unItem.setCantidadComprada(cantidad);
        // La lista de items registrada es la misma que tengo guardada por ende puedo gettearla
        // y modificarla por fuera, como son una referencia, this.registroDeCompras sera afectada
        listaDeItemsRegistrada.add(unItem);
    }

    public void imprimirFactura(Cliente clienteAFacturar) {
        if (this.registroDeCompras.containsKey(clienteAFacturar) == false) {
            System.out.println("El cliente no registro compras");
        }
        Factura nuevaFactura = new Factura(clienteAFacturar, this.registroDeCompras.get(clienteAFacturar), registroDeVentas.size());
        registroDeVentas.add(nuevaFactura);
        System.out.println("----------------------------");
        System.out.println("Factura Nº: " + nuevaFactura.getNumeroDeFactura());
        System.out.println("Lista De Items");
        System.out.printf("\t %-15.10s %-15.10s %-15.10s %-15.10s \n", "Producto", "Costo Unitario", "Cantidad", "Total");
        registroDeCompras.get(clienteAFacturar).stream().forEach(Item::imprimirDatosItem);
        System.out.println("Total : $" + nuevaFactura.getTotal());
        System.out.println("----------------------------\n");
    }

    public void imprimirDatosDeCliente() {
        System.out.println("----------------------------");
        System.out.println("Datos del Cliente:");
        System.out.printf("\t %-15.15s %-15.15s %-15.15s \n", "Nombre", "Apellido", "DNI");
        registroDeCompras.keySet().stream().forEach(Cliente::imprimirDatos);
        System.out.println("----------------------------\n");

    }

    public void removerCliente(Cliente clienteARemover) {
        if (this.registroDeCompras.containsKey(clienteARemover) == false) {
            return;
        }
        System.out.println("Cliente a remover");
        clienteARemover.imprimirDatos();
        this.registroDeCompras.remove(clienteARemover);
        System.out.println("Cliente removido con exito");
    }

    public void buscarClientePorDNI() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese DNI del cliente a buscar");
        String DniToSearch = teclado.nextLine();

        try {
            Cliente clienteABuscar = this.registroDeCompras.
                    keySet().
                    stream().
                    filter((Cliente c) -> c.hasSameDNI(DniToSearch)).
                    findFirst().
                    get();
            clienteABuscar.imprimirDatos();
        } catch (NoSuchElementException e) {
            System.out.println("No se encontro al cliente");
        }
    }
}
