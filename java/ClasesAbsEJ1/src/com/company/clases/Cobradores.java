package com.company.clases;

import com.company.interfaces.ConsultaSaldo;
import com.company.interfaces.RetiroDeEfectivo;
import com.company.interfaces.Transaccion;

public class Cobradores implements RetiroDeEfectivo, ConsultaSaldo, Transaccion {
    @Override
    public void consultaSaldo() {
        System.out.print("Este es su saldo: $$$");
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
