package ejercicioBanco;

public class Deposito extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito exitoso.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito falló.");
    }
}
