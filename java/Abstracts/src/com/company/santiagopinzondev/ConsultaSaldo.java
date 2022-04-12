package com.company.santiagopinzondev;

public class ConsultaSaldo implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Se realizo la consulta del saldo");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se realizo la consulta del saldo");
    }
}
