package clientes;

import interfaces.Deposito;
import interfaces.Transferencia;

public class ClienteEjecutivo {
    public void realizarDeposito(){
        Deposito d = new Deposito();
        // para probar ambos casos
        if (Math.random() < 0.5) {
            d.transaccionOk();
        } else {
            d.transaccionNoOk();
        }
    }
    public void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        // para probar ambos casos
        if (Math.random() < 0.5) {
            transferencia.transaccionOk();
        } else {
            transferencia.transaccionNoOk();
        }
    }
}
