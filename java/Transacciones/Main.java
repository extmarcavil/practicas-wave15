package Transacciones;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionOk("Transferencia");
        ejecutivo.transaccionNoOk("Depósito");
    }
}
