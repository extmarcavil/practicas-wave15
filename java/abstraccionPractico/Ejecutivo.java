package abstraccionPractico;

public class Ejecutivo implements Deposito,Transferencia{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un problema en la transaccion");

    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando Transferencia");
    }
}
