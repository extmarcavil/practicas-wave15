package com.company.clientes;

import com.company.Transaccion;
import com.company.transacciones.ConsultarSaldo;
import com.company.transacciones.PagarServicio;
import com.company.transacciones.Retirar;

public class Basic implements PagarServicio, ConsultarSaldo, Retirar {
    String saldo = "El saldo actual es X";
    String exito = "Transaccion realizada con exito";
    String error = "Hubo un inconveniente";

    public Basic(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String transaccionOk() {
        return exito;
    }

    @Override
    public String transaccionNoOk() {
        return error;
    }


    @Override
    public void pagarServicio() {
        System.out.println("Usted pago");
        System.out.println(transaccionNoOk());
    }

    @Override
    public void retirar() {
        System.out.println("Usted retiro");
        System.out.println(transaccionOk());
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Usted consulta");
        System.out.println(transaccionOk());

    }
}
