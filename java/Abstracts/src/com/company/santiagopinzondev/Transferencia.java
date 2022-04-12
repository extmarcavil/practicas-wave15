package com.company.santiagopinzondev;

public class Transferencia implements Transaction{

    @Override
    public void transactionOk() {
        System.out.println("Se hizo la transaccion");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se hizo la transaccion");
    }

}
