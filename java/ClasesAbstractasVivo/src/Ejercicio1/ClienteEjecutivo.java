package Ejercicio1;

public class ClienteEjecutivo implements Deposito, Transferencia{

    private int saldo;

    public ClienteEjecutivo(int saldo){
        this.saldo = saldo;
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transacción fue OK.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no fue OK.");
    }

    @Override
    public void depositar(int cantidad) {
        this.saldo = saldo + cantidad;
        System.out.println("Usted despositó " + cantidad + " pesos.");

    }

    @Override
    public void transferir(int cantidad) {
        this.saldo = saldo - cantidad;
        System.out.println("Ha enviado " + cantidad + " pesos.");
    }
}
