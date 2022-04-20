package Ejercicio1;

public class ClienteCobrador implements Retiro, ConsultaSaldo{

    private int saldo;

    public ClienteCobrador(int saldo){
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
    public void retirar(int cantidad) {
        this.saldo = saldo - cantidad;
        System.out.println("Retiró " + cantidad + " pesos.");
    }

    @Override
    public void consultar() {
        System.out.println("Usted tiene " + this.saldo + " pesos.");
    }
}
