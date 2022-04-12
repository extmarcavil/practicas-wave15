package transacciones;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no permitida.");
    }
}
