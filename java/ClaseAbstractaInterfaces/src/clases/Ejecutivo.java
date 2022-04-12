package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc+" Realizada");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("Error,  el tipo de transaccion: '"+tipoTransacc+"' no se pudo realizar");
    }

    @Override
    public String hacerDeposito() {
        return "realizando Deposito...";
    }

    @Override
    public String hacerTransferencia() {
        return "realizando transferencia";
    }
}
