package abstractasInterfaces.ejercicio1.Transaction.Impl;

import abstractasInterfaces.ejercicio1.Transaction.Transaction;

public class PayServices implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Realizanod pago de servicio");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Pago de servcios fallido");
    }
}
