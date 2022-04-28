package com.company.clientes;

import com.company.transacciones.ConsultarSaldo;
import com.company.transacciones.Retirar;

public class Cobrador implements Retirar, ConsultarSaldo {

    String saldo = "El saldo actual es X";
    String exito = "Transaccion realizada con exito";
    String error = "Hubo un inconveniente";

    @Override
    public String transaccionOk() {
        return exito;
    }

    @Override
    public String transaccionNoOk() {
        return error;
    }


    @Override
    public void consultarSaldo() {
        System.out.println(saldo);
    }

    @Override
    public void retirar() {

    }
}
