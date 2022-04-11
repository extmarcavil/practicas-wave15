package com.company.banco;

public class Ejecutivo implements Transaccion {

    public void deposito(){
        System.out.println("Se esta realizando el deposito.");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
