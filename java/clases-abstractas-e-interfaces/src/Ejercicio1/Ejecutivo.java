package Ejercicio1;

public class Ejecutivo extends Cliente {
    @Override
    public void depositar() {
        this.deposito.transaccionOk();
    }

    @Override
    public void transferir() {
        this.transferencia.transaccionOk();
    }
}
