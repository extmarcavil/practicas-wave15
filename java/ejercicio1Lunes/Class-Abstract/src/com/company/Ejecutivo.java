package com.company;

public class Ejecutivo extends Cliente{


    @Override
    public void Depositar(Transaccion transaccion) {
        transaccion.transaccionOk();
    }

    @Override
    public void transferir(Transaccion t) {
        t.transaccionOk();
    }

    @Override
    public void consultarSaldo(Transaccion t) {
        t.transaccionesNoOk();
    }

    @Override
    public void pagoDeServicios(Transaccion t) {
        t.transaccionesNoOk();
    }

    @Override
    public void retirarEfectivo(Transaccion t) {
        t.transaccionesNoOk();
    }
}
