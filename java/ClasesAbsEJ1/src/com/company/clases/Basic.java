package com.company.clases;

import com.company.interfaces.ConsultaSaldo;
import com.company.interfaces.PagoServicio;
import com.company.interfaces.RetiroDeEfectivo;
import com.company.interfaces.Transaccion;

public class Basic implements Transaccion, ConsultaSaldo, PagoServicio, RetiroDeEfectivo {
    @Override
    public void consultaSaldo() {
        System.out.print("Este es su saldo: $$$");
    }

    @Override
    public void pagoServicio() {
        System.out.print("Se pagó el servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.print("Se retiró el efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.print("Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.print("Transaccion NO OK");
    }
}
