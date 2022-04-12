public class Ejecutivo extends Cliente implements Deposito, Transferencia {


    @Override
    public double deposito(double monto) {
        return 0;
    }

    @Override
    public double transferencia(double monto) {
        return 0;
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
