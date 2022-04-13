package Ejercicio1;

public class ClienteEjecutivo implements Deposito, Transferencia{

    private int cantDeposito;
    private int cantTransferido;

    public ClienteEjecutivo(int cantDeposito, int cantTransferido) {
        this.cantDeposito = cantDeposito;
        this.cantTransferido = cantTransferido;
    }

    @Override
    public void depositar() {
        System.out.println("CLIENTE EJECUTIVO\nSe depositaron " + cantDeposito + " pesos\n");
    }

    @Override
    public void transaccionOk() {
        System.out.println("CLIENTE EJECUTIVO\nLa transaccion fue OK.\n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("CLIENTE EJECUTIVO\nLa transaccion no fue OK.\n");
    }

    @Override
    public void transferir() {
        System.out.println("CLIENTE EJECUTIVO\nSe han transferido " + cantTransferido + " pesos\n");
    }
}
