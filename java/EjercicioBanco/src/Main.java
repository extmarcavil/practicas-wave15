import operaciones.Basic;
import operaciones.Cliente;
import operaciones.Ejecutivo;
import operaciones.Cobrador;
import transacciones.*;

public class Main {
    public static void main(String[] args) {

        Cliente basic = new Basic();
        Cliente ejecutivo = new Ejecutivo();
        Cliente cobrador = new Cobrador();

        Transaccion consultarSaldo = new ConsultaSaldo();
        Transaccion deposito = new Deposito();
        Transaccion retiro = new RetiroEfectivo();
        Transaccion transferencia = new Transferencia();

        basic.realizarConsultaSaldo(consultarSaldo);
        basic.realizarDeposito(deposito);

        ejecutivo.realizarDeposito(deposito);
        ejecutivo.realizarConsultaSaldo(consultarSaldo);

        cobrador.realizarRetiroDeEfectivo(retiro);
        cobrador.realizarTransferencia(transferencia);

    }
}
