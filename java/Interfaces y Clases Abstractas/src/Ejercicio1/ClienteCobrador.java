package Ejercicio1;

public class ClienteCobrador implements ConsultaSaldo, Retiro{

    private int saldo;
    private int retirado;

    public ClienteCobrador(int saldo, int retirado) {
        this.saldo = saldo;
        this.retirado = retirado;
    }

    @Override
    public void consultar() {
        System.out.println("CLIENTE COBRADOR \nSu saldo es de " + saldo + " pesos\n");
    }

    @Override
    public void retirar() {
        System.out.println("CLIENTE COBRADOR\nSe han retirado " + retirado + " pesos\n");
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transaccion fue OK.\n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no fue OK.\n");
    }
}
