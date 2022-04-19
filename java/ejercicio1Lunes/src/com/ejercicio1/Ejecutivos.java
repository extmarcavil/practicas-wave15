package com.ejercicio1;

public class Ejecutivos {
    private Transacciones depositoServicio;
    private Transacciones transferenciaServicio;

    public Ejecutivos() {
        this.depositoServicio = new Depositar();
        this.transferenciaServicio = new Transferencia();
    }

    public void ejecutarDepósito () {
        this.depositoServicio.transaccionOk();
    }

    public void ejecutarTransferencia () {
        this.transferenciaServicio.transaccionOk();
    }
}
