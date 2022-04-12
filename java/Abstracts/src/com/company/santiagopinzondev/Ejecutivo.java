package com.company.santiagopinzondev;

public class Ejecutivo extends Cliente{

    @Override
    public void depositar() {
        deposito.transactionOk();
    }

    @Override
    public void transferencia() {
        transferencia.transactionOk();
    }

    @Override
    public void retiroEfectivo() {
        retiroEfectivo.transactionNoOk();
    }

    @Override
    public void consultaSaldo() {
        consultaSaldo.transactionNoOk();
    }

    @Override
    public void PagoServicios() {
        pagoServicios.transactionNoOk();
    }
}
