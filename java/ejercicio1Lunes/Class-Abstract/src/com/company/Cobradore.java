package com.company;


public class Cobradore extends Cliente{

    @Override
    public void Depositar(Transaccion transaccion) {
        transaccion.transaccionesNoOk();
    }

    @Override
    public void transferir(Transaccion t) {
        t.transaccionesNoOk();
    }

    @Override
    public void consultarSaldo(Transaccion t) {
        t.transaccionOk();
    }

    @Override
    public void pagoDeServicios(Transaccion t) {
        t.transaccionesNoOk();
    }

    @Override
    public void retirarEfectivo(Transaccion t) {
        t.transaccionOk();
    }
}
