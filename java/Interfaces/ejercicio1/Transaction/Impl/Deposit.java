package abstractasInterfaces.ejercicio1.Transaction.Impl;

import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class Deposit implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Realizando depósito");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Depósito fallido");
    }
}
