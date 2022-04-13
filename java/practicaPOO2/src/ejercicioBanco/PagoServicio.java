package ejercicioBanco;

public class PagoServicio extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio exitoso.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago de servicio falló.");
    }
}
