package abstractasInterfaces.ejercicio1.Transaction.Impl;

import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class CashWithdrawal implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Realizando retiro en efectivo");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Retiro en efectivo terminado");
    }
}
