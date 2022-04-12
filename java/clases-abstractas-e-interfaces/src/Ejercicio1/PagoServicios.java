package Ejercicio1;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Servicio pagado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No es posible pagar servicios.");
    }
}
