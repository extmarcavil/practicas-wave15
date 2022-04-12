package com.company.santiagopinzondev;

public class Cobrador extends Cliente{


    @Override
    public void depositar() {
        deposito.transactionNoOk();
    }

    @Override
    public void transferencia() {
        transferencia.transactionNoOk();
    }

    @Override
    public void retiroEfectivo() {
        retiroEfectivo.transactionOk();
    }

    @Override
    public void consultaSaldo() {
        consultaSaldo.transactionOk();
    }

    @Override
    public void PagoServicios() {
        pagoServicios.transactionNoOk();
    }
}
