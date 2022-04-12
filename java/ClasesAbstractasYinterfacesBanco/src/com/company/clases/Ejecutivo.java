package com.company.clases;

import com.company.interfaces.TransaccionesEjecutivos;

public class Ejecutivo implements TransaccionesEjecutivos {

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " no pudo ser realizado correctamente");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Hacer Transferencia");
    }

    @Override
    public void hacerDeposito() {
        System.out.println("Hacer Deposito");
    }

}
