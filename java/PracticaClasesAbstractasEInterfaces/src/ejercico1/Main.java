package ejercico1;

import ejercico1.clientes.Cliente;
import ejercico1.clientes.Cobrador;
import ejercico1.clientes.Ejecutivo;
import ejercico1.transacciones.*;

public class Main {
    public static void main(String[] args) {
        Cliente unCliente = new Ejecutivo();

        unCliente = new Cobrador();

        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
        RetiroDeEfectivo retiroDeEfectivo = new RetiroDeEfectivo();
        PagoDeServicios pagoDeServicios = new PagoDeServicios();

        System.out.println(deposito.ejecutar(unCliente));
        System.out.println(retiroDeEfectivo.ejecutar(unCliente));
    }
}
