package clientes;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicios;

public class ClienteCobrador {
    public void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        // para probar ambos casos
        if (Math.random() < 0.5) {
            consultaSaldo.transaccionOk();
        } else {
            consultaSaldo.transaccionNoOk();
        }
    }
    public void pagarServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        // para probar ambos casos
        if (Math.random() < 0.5) {
            pagoServicios.transaccionOk();
        } else {
            pagoServicios.transaccionNoOk();
        }
    }
}
