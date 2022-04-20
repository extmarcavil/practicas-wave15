package Ejercicio1;

public class ClienteBasico implements ConsultaSaldo, PagoDeServicios, Retiro{

    private int saldo;

    public ClienteBasico(int saldo){
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
    public void consultar() {
       System.out.println("Usted tiene " + saldo +  " pesos.");
    }

    @Override
    public void pagarServicio(int costo) {
        this.saldo = saldo - costo;
        System.out.println("Usted ha pagado la luz.");
    }

    @Override
    public void retirar(int cantidad) {
        this.saldo = saldo - cantidad;
        System.out.println("Retiró " + cantidad + " pesos.");
    }
}
