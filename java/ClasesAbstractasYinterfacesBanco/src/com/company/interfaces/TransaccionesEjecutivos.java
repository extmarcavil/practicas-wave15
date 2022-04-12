package com.company.interfaces;

import com.company.interfaces.Transaccion;

public interface TransaccionesEjecutivos extends Transaccion {

    public void hacerTransferencia();
    public void hacerDeposito();
}
