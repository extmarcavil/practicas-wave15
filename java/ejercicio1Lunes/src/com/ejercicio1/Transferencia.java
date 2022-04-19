package com.ejercicio1;

public class Transferencia implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. No se pudo realizar la transferencia");
    }
}
