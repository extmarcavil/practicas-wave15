package AbstractasInterfaces.Ejercicio1;

public class Main {
    public static void main(String[] args) {

        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basic.saldo();
        basic.extraer(300);
        basic.transaccionOk();

        ejecutivo.depositar(1000);
        ejecutivo.transaccionOk();

        cobrador.saldo();
        ejecutivo.transferir(233);
        ejecutivo.transaccionNoOk();
    }
}
