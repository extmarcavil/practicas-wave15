package com.company.clases;

import com.company.interfaces.TransaccionesCobradores;

public class Cobrador implements TransaccionesCobradores {

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion +  " no pudo ser realizada correctamente");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consulta saldo");
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Monto que se quiere retirar: " + monto);
    }

}
