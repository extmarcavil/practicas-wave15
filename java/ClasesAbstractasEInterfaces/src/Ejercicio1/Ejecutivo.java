package Ejercicio1;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void realizarDeposito(int monto) {
        System.out.println("Depositaste " + monto);
    }

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void realizarTransferencia(int monto, String destino) {
        System.out.println("Transferiste " + monto + " a " + destino);
    }
}
