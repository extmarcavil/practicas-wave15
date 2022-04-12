package ejercicio1;

public class Transferencia extends Transaccion{

    public Transferencia(Cliente clienteQueTransferira) {
        super(clienteQueTransferira);
    }

    @Override
    public void transaccionOK(Cliente cliente) {
        System.out.println(cliente.nombre() + " realizo con exito la transferencia");
    }

    @Override
    public void transaccionNOK(Cliente cliente) {
        System.out.println(cliente.nombre() + " no realizo con exito la transferencia");
    }
}
