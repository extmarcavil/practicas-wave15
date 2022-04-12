package com.company.clases;

import com.company.interfaces.Transaccion;
import com.company.interfaces.TransaccionesBasic;

public class Basic implements TransaccionesBasic, Transaccion {

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " realizado correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " no pudo ser realizado correctamente");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consulta de saldo");
    }

    @Override
    public void pagarServicio(String tipoDeServicio) {
        System.out.println("Pago del Servicio");
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirar Efectivo");
    }

}
