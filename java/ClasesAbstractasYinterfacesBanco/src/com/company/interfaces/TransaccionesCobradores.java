package com.company.interfaces;

import com.company.interfaces.Transaccion;

public interface TransaccionesCobradores extends Transaccion {

    public void retirarEfectivo(Double monto);
    public void consultarSaldo();

}
