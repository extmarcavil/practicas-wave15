package transacciones;

public class PagoServicios implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no permitida.");
    }
}
