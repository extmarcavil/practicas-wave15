package interfaces;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicio --> OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Realizando pago de servicio --> ERROR");
    }
}
