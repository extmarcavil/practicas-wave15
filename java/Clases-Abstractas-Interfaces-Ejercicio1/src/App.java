import clientes.ClienteBasico;
import clientes.ClienteCobrador;
import clientes.ClienteEjecutivo;

public class App {
    public static void main(String[] args) {
        ClienteBasico clienteBasico = new ClienteBasico();
        clienteBasico.consultarSaldo();
        clienteBasico.pagarServicios();
        clienteBasico.retirarEfectivo();

        ClienteCobrador clienteCobrador = new ClienteCobrador();
        clienteCobrador.consultarSaldo();
        clienteCobrador.pagarServicios();

        ClienteEjecutivo clienteEjecutivo = new ClienteEjecutivo();
        clienteEjecutivo.realizarDeposito();
        clienteEjecutivo.realizarTransferencia();
    }
}
