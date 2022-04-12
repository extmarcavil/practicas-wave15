package clasesAbstractasEinterfaces1.clientes;

import clasesAbstractasEinterfaces1.Transacciones.ConsultaSaldo;
import clasesAbstractasEinterfaces1.Transacciones.PagoServicios;
import clasesAbstractasEinterfaces1.Transacciones.RetiroEnEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEnEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("consultando saldo");
    }

    @Override
    public void pagoServicios() {
        System.out.println("pagar servicios");
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
        System.out.println("Transaccion no ok");
    }
}
