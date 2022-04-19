package com.ejercicio1;

public class Basicos {
    private Transacciones retiroServicio;
    private Transacciones consultaServicio;
    private Transacciones pagoServicio;
    private Transacciones depositoServicio;

    public Basicos() {
        this.consultaServicio = new ConsultaDeSaldo();
        this.pagoServicio = new PagoDeServicios();
        this.retiroServicio = new Retiro();
        this.depositoServicio = new Depositar();
    }

    public void consultaDeSaldo () {
        this.consultaServicio.transaccionOk();
    }

    public void pagoDeServicio () {
        this.pagoServicio.transaccionOk();
    }

    public void retiroDeDinero () {
        this.retiroServicio.transaccionOk();
    }

    public void depositarDinero () {
        this.depositoServicio.transaccionNoOk();
    }
}
