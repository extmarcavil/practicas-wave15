package com.company;

import com.company.clases.Basic;
import com.company.clases.Cobrador;
import com.company.clases.Ejecutivo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String tiposervicio = "Prestamo";

        System.out.println("------- Transacciones del usuario tipo Basic -------");
        Basic b = new Basic();
        b.consultarSaldo();
        b.pagarServicio(tiposervicio);
        b.retirarEfectivo(20500.8);
        b.transaccionNoOk("Pago del Servicio: ");
        b.transaccionOk("Consulta de saldo: ");
        b.transaccionOk("Retiro de Efectivo: ");
        System.out.println("------- Transacciones del usuario tipo Ejecutivo -------");
        Ejecutivo e = new Ejecutivo();
        e.hacerDeposito();
        e.hacerTransferencia();
        e.transaccionNoOk("El Depósito ");
        e.transaccionOk("Transferencia");
        System.out.println("------- Transacciones del usuario tipo Cobrador -------");
        Cobrador c = new Cobrador();
        c.consultarSaldo();
        c.retirarEfectivo(3600.23);
        c.transaccionOk("Consulta saldo");
        c.transaccionNoOk("El Retiro de Efectivo");


    }
}
