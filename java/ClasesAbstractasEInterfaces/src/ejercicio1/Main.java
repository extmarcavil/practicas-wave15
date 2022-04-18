package ejercicio1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Cliente Básico: ");
        Basico clienteBasico = new Basico();
        clienteBasico.consultarSaldo();
        clienteBasico.pagarServicios();
        clienteBasico.retirarEfectivo();
        System.out.println();

        System.out.println("Cliente Ejecutivo");
        Ejecutivos clienteEjecutivo = new Ejecutivos();
        clienteEjecutivo.depositar();
        clienteEjecutivo.transferir();
        System.out.println();

        System.out.println("Cliente Cobrador");
        Cobradores clienteCobrador = new Cobradores();
        clienteCobrador.consultarSaldo();
        clienteCobrador.retirarEfectivo();
    }
}
