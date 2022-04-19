package com.company;

public abstract class Cliente {

    public abstract void Depositar(Transaccion transaccion);

    public abstract void transferir(Transaccion t);

    public abstract void consultarSaldo(Transaccion t);

    public abstract void pagoDeServicios(Transaccion t);

    public abstract void retirarEfectivo(Transaccion t);

}
