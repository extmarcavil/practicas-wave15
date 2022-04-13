package ejercicio1;

public class Deposito extends Transaccion{
    public Deposito(Cliente clienteQueRealizaElDeposito) {
        super(clienteQueRealizaElDeposito);
    }

    @Override
    public void transaccionOK(Cliente cliente) {
        System.out.println(cliente.nombre() + " realizo con exito el deposito");
    }

    @Override
    public void transaccionNOK(Cliente cliente) {
        System.out.println(cliente.nombre() + " no realizo con exito el deposito");
    }

}
