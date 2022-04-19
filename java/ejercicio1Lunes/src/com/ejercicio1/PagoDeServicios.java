package com.ejercicio1;

public class PagoDeServicios implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Se ha pagado un servicio con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. No se ha podido pagar el servicio");
    }
}
