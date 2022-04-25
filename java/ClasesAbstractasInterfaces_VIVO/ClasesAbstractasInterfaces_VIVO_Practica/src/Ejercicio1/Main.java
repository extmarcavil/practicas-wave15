package Ejercicio1;

public class Main {
    public static void main(String[] args) {


        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();


        ejecutivo.depositar();
        basic.consultarSaldo();
        cobrador.retirar();



    }
}
