package com.company.santiagopinzondev;

public class Deposito implements Transaction{

    @Override
    public void transactionOk() {
        System.out.println("Se hizo el deposito");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se hizo el deposito");
    }
}
