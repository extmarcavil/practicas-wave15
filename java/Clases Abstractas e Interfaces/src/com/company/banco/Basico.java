package com.company.banco;

public class Basico extends Cobrador implements Transaccion{

    public void pagoServicio(){
        System.out.println("Se esta pagando un servicio.");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
