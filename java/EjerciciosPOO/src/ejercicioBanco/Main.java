package ejercicioBanco;

public class Main {
    public static void main(String[] args) {
        Ejecutivo c1 = new Ejecutivo();
        c1.realizarTransaccion(new Deposito());
        c1.realizarTransaccion(new Transferencia());
        c1.realizarTransaccion(new RetiroEfectivo());
        System.out.println(c1.toString());

        Basico c2 = new Basico();
        c2.realizarTransaccion(new ConsultaSaldo());
        c2.realizarTransaccion(new PagoServicio());
        c2.realizarTransaccion(new RetiroEfectivo());
        System.out.println(c2.toString());

        Cobrador c3 = new Cobrador();
        c3.realizarTransaccion(new RetiroEfectivo());
        c3.realizarTransaccion(new ConsultaSaldo());
        System.out.println(c3.toString());
    }
}
