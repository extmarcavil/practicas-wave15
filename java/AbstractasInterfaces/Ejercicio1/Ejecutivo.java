package AbstractasInterfaces.Ejercicio1;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar(double monto) {
        System.out.println("Depósitando $" + monto);
    }

    @Override
    public void transferir(double monto) {
        System.out.println("Transfiriendo $" + monto);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción Realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar la transacción");
    }
}
