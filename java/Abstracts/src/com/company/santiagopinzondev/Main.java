package com.company.santiagopinzondev;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    ArrayList<Cliente> listClientes = new ArrayList<>();

	Ejecutivo ejecutivo = new Ejecutivo();
	Basico basico = new Basico();
	Cobrador cobrador = new Cobrador();
	listClientes.add(ejecutivo);
	listClientes.add(basico);
	listClientes.add(cobrador);

	for (Cliente client: listClientes) {
        System.out.println(client.getClass());
        client.consultaSaldo();
        client.PagoServicios();
        client.retiroEfectivo();
        client.transferencia();
        client.depositar();
        System.out.println("-----------------------\n");
    }


    }
}
