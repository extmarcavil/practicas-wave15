package ejercicio1;

public class ConsultarSaldo extends Transferencia{

        public ConsultarSaldo(Cliente clienteQueTransferira) {
            super(clienteQueTransferira);
        }

        @Override
        public void transaccionOK(Cliente cliente) {
            System.out.println(cliente.nombre() + " realizo con exito la consulta de saldo");
        }

        @Override
        public void transaccionNOK(Cliente cliente) {
            System.out.println(cliente.nombre() + " no realizo con exito la consulta de saldo");
        }
}

