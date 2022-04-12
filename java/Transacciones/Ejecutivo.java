package Transacciones;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando depósito...");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " relizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no pudo ser realizada");
    }
}
