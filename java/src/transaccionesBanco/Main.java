package transaccionesBanco;

public class Main {
    public static void main(String[] args) {

        Ejecutivo e = new Ejecutivo(10000,"5555");
        Basic b = new Basic(5000, "777");
        Cobrador c = new Cobrador(15000, "222");

        e.realizarDeposito();
        e.realizarTransferencia();
        System.out.println("");

        b.pagarServicios();
        b.consultarSaldo();
        b.retirarEfectivo();
        System.out.println("");

        c.consultarSaldo();
        c.retirarEfectivo();
        System.out.println("");

    }
}
