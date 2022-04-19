package com.ejercicio1;

public class ConsultaDeSaldo implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado un consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. No se ha podido realizar la consulta de saldo");
    }
}
