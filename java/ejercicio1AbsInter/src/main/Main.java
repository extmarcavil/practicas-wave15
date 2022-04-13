package main;

public class Main {

    public static void main(String[] args) {

        Ejecutivo ejecutivo1 = new Ejecutivo();
        ejecutivo1.realizarDeposito();
        ejecutivo1.transaccionOk();
        ejecutivo1.realizarTransferencia();
        ejecutivo1.transaccionNoOk();
        System.out.println("--------");
        Basic basic1 = new Basic();
        basic1.consultarSaldo();
        basic1.transaccionOk();
        basic1.realizarPagoDeServicio();
        basic1.transaccionOk();
        basic1.retirarEfectivo();
        basic1.transaccionNoOk();
        System.out.println("--------");
        Cobrador cobrador1 = new Cobrador();
        cobrador1.consultarSaldo();
        cobrador1.transaccionNoOk();
        cobrador1.retirarEfectivo();
        cobrador1.transaccionOk();

    }

}
