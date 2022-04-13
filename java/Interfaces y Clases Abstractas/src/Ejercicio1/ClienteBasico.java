package Ejercicio1;

public class ClienteBasico implements ConsultaSaldo, PagoDeServicios, Retiro{

    private int saldo;
    private int cantRetirado;

    public ClienteBasico(int saldo, int cantRetirado){
        this.saldo= saldo;
        this.cantRetirado = cantRetirado;
    }


    @Override
    public void transaccionOk() {
        System.out.println("CLIENTE BASICO\nLa transaccion fue OK.\n");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("CLIENTE BASICO\nLa transaccion no fue OK.\n");
    }

    @Override
    public void consultar() {
        System.out.println("CLIENTE BASICO\nUsted tiene " + saldo +" pesos\n");
    }

    @Override
    public void pagar() {
        System.out.println("CLIENTE BASICO\nUsted ha pagado la luz\n");
    }

    @Override
    public void retirar() {
        System.out.println("CLIENTE BASICO\nHa retirado " + cantRetirado +"  pesos\n");
    }
}
