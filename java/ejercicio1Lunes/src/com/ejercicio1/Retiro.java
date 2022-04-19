package com.ejercicio1;

public class Retiro implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de dinero realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. No se pudo realizar el retiro de dinero");
    }
}
