package main;

public class Factura {
    private int numero;
    private char tipo;
    private Cliente cliente;
    private int total;
    private Item item;
    private int contFacturas = 0;

    public Factura(char tipo, Cliente cliente, int total, Item item) {
        this.numero = contFacturas++;
        this.tipo = tipo;
        this.cliente = cliente;
        this.total = total;
        this.item = item;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Factura: " +
                "\nNumero: " + numero +
                "\nTipo: " + tipo +
                "\nCliente: " + cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getDni() +
                "\nItem: " + item.getNombre() + " " + item.getCantidad() +
                "\nTotal:" + total;
    }
}
