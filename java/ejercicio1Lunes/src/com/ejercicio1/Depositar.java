package com.ejercicio1;

public class Depositar implements Transacciones {

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. No se pudo realizar el depósito");
    }
}
