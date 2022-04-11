package abstractasInterfaces.ejercicio1.Transaction.Impl;

import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class Transfer implements Transaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transferencia fallida");
    }
}
