package EjercicioPracticoClasesAbstractasEInterfaces.Animales.Banco;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no realizada");
    }

    @Override
    public void depositarDinero() {
        System.out.println("/tDepósito realizado");
    }

    @Override
    public void transferirDinero() {
        System.out.println("/tTransferencia");
    }
}
