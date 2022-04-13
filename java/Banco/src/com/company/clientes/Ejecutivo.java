package com.company.clientes;

import com.company.transacciones.Depositar;
import com.company.transacciones.Transferencia;

public class Ejecutivo implements Depositar, Transferencia {

    String exito = "Transaccion realizada con exito";
    String error = "Hubo un inconveniente";

    @Override
    public String transaccionOk() {
        return exito;
    }

    @Override
    public String transaccionNoOk() {
        return error;
    }


    @Override
    public void hacerDeposito() {
        System.out.println("Usted desposito");
        System.out.println(transaccionOk());
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Usted hizo transferencia");
        System.out.println(transaccionOk());

    }
}
