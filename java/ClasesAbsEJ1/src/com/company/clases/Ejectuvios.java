package com.company.clases;

import com.company.interfaces.Deposito;
import com.company.interfaces.Transaccion;
import com.company.interfaces.Transferencia;

public class Ejectuvios implements Transaccion, Deposito, Transferencia {
    @Override
    public void depositar() {
        System.out.print("Se realizo el deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.print("Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.print("Transaccion NO OK");
    }

    @Override
    public void transferir() {
        System.out.print("Se realizo la transferencia");
    }
}
