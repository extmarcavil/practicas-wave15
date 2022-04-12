package clasesAbstractasEinterfaces1.clientes;

import clasesAbstractasEinterfaces1.Transacciones.Depositos;
import clasesAbstractasEinterfaces1.Transacciones.Transferencia;

public class Ejecutivos implements Depositos, Transferencia {


    @Override
    public void transactionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transactionNoOk() {

    }

    @Override
    public void transferir() {

    }

    @Override
    public void depositar() {

    }
}
