package Ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Ejecutivo());
        clientes.add(new Basic());
        clientes.add(new Cobrador());

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getClass().getName());

            cliente.depositar();
            cliente.consultarSaldo();
            cliente.transferir();
            cliente.retirarEfectivo();
            cliente.pagarServicios();

            System.out.println("\n-----------------------------------------\n");
        }
    }
}
