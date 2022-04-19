package com.ejercicio1;

public class Cobradores {
    private Transacciones retiroServicio;
    private Transacciones consultaServicio;

    public Cobradores() {
        this.retiroServicio = new Retiro();
        this.consultaServicio = new ConsultaDeSaldo();
    }

    public void retirarDinero () {
        this.retiroServicio.transaccionOk();
    }

    public void consultarSaldo () {
        this.consultaServicio.transaccionOk();
    }
}
