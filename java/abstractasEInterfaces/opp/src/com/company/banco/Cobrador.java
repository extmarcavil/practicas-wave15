package com.company.banco;

public class Cobrador implements Transaccion {

    public void consultaSaldo(){
        System.out.println("Se esta consultando el saldo.");
    }

    public void retiroEfectivo(){
        System.out.println("Se esta retirando el efectivo.");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
