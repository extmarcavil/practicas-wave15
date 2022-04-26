package com.bootcamp.clases;

import com.bootcamp.interfaces.ConsultaSaldo;
import com.bootcamp.interfaces.PagoServicio;
import com.bootcamp.interfaces.RetiroEfec;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfec {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
   }

    @Override
    public void pagarServicio(String tipoServ) {
        System.out.println("Pagando servicio: " + tipoServ);
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Intentando retirar: " + monto);
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
