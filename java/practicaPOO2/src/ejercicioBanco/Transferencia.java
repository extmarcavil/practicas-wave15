package ejercicioBanco;

public class Transferencia extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia falló.");
    }
}
