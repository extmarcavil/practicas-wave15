package clasesAbstractasEinterfaces1.clientes;

import clasesAbstractasEinterfaces1.Transacciones.ConsultaSaldo;
import clasesAbstractasEinterfaces1.Transacciones.RetiroEnEfectivo;

public class Cobrador implements ConsultaSaldo, RetiroEnEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("consultando saldo");
    }

    @Override
    public void retirar() {
        System.out.println("retirar efectivo");
    }


    @Override
    public void transactionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transactionNoOk() {

    }
}
