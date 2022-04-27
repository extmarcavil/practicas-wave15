package integradora;

public class Ejecutivo implements Transaccion{

    public void deposito() {
        System.out.println("Realizando depósito...");
    }

    public void transferencia() {
        System.out.println("Realizando transferencia...");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Cliente Cobrador, transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cliente Cobrador, transacción exitosa.");
    }
}
