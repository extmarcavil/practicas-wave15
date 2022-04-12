package transacciones;

public class ConsultaSaldo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no permitida.");
    }
}
