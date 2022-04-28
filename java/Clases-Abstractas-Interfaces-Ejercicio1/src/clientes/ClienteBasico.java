package clientes;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicios;
import interfaces.RetiroEfectivo;

public class ClienteBasico {
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
        if (Math.random() < 0.5) {
            pagoServicios.transaccionOk();
        } else {
            pagoServicios.transaccionNoOk();
        }
    }
    public void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        // para probar ambos casos
        if (Math.random() < 0.5) {
            retiroEfectivo.transaccionOk();
        } else {
            retiroEfectivo.transaccionNoOk();
        }
    }
}
