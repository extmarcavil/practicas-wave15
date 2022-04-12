package com.company.santiagopinzondev;

public class RetiroEfectivo implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Se hizo el retiro");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se hizo el retiro");
    }
}
