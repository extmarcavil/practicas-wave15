package Ejercicio1;

public class Main {

    public static void main(String args[]){
        ClienteBasico basico = new ClienteBasico(2000);
        basico.consultar();
        basico.pagarServicio(500);
        basico.retirar(500);
        basico.transaccionNoOk();
        basico.transaccionOk();

        ClienteEjecutivo ejecutivo = new ClienteEjecutivo(4000);
        ejecutivo.depositar(1500);
        ejecutivo.transferir(2000);
        ejecutivo.transaccionNoOk();
        ejecutivo.transaccionOk();

        ClienteCobrador cobrador = new ClienteCobrador(8000);
        cobrador.retirar(2500);
        cobrador.consultar();
        cobrador.transaccionNoOk();
        cobrador.transaccionOk();

    }

}
