package Ejercicio1;

public class Main {
    public static void main(String[] args) {

        ClienteBasico basico = new ClienteBasico(100, 200);
        basico.consultar();
        basico.pagar();
        basico.retirar();

        ClienteCobrador cobrador = new ClienteCobrador(500,200);
        cobrador.consultar();
        cobrador.retirar();

        ClienteEjecutivo ejecutivo = new ClienteEjecutivo(400,200);
        ejecutivo.depositar();
        ejecutivo.transferir();
    }
}
