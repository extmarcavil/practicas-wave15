package IntegradoresP1.Supermercado;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Factura {
    private Cliente cliente;
    private List<Item> items = new LinkedList<>();
    private double total;

    public Factura() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura del cliente " + cliente + ":\n" +
                "\tItems:\n\t" + items +
                "\n\tTotal: $" + total;
    }

    public void agregarItem(Scanner input){
        // Agregar un item a una factura.
        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.print("Nombre: ");
        String nombre = input.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(input.nextLine());
        System.out.print("Precio: ");
        double costo = Double.parseDouble(input.nextLine());
        Item item1 = new Item(codigo, nombre, cantidad, costo);
        items.add(item1);
        System.out.println("(+) Item agregado.");
    }

    public void eliminarItem(Scanner input) {
        // Eliminar un item de una factura.
        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(input.nextLine());
        Item item = items.stream().filter(i -> i.getCodigo() == codigo).findFirst().get();
        items.remove(item);
        System.out.println("(-) Item eliminado.");
    }

    public void mostrarItems() {
        // Mostrar los items de una factura.
        items.forEach(System.out::println);
    }

    public void calcularTotal(Factura factura){
        // Calcular el total de una factura.
        double total = 0;
        for (Item item : factura.getItems()){
            total += item.getCostoUnitario() * item.getCantidadComprada();
        }
        factura.setTotal(total);
    }
}
