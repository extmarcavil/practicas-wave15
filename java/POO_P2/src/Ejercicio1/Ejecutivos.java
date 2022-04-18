package Ejercicio1;

public class Ejecutivos implements Deposito, Transferencia{
    @Override
    public void transaccionOk() {
        Deposito.super.transaccionOk();
    }

    @Override
    public void transaccionNoOk() {
        Deposito.super.transaccionNoOk();
    }

    public void realizarDeposito(){
        Deposito.super.transaccionOk();
    }

    public void realizarTransferencia(){
        Transferencia.super.transaccionOk();
    }
}
