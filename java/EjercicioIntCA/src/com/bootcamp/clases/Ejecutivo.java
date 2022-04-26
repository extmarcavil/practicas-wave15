package com.bootcamp.clases;

import com.bootcamp.interfaces.Deposito;
import com.bootcamp.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Intentando hacer depósito...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }
}
