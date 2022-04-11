package abstractasInterfaces.ejercicio1.Transaction.Impl;

import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class CheckBalance implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Consulta de saldo fallida");
    }
}
