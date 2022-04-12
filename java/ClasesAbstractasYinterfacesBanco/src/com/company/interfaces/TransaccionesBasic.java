package com.company.interfaces;

import com.company.interfaces.Transaccion;

public interface TransaccionesBasic extends Transaccion {

    public void consultarSaldo();
    public void pagarServicio(String tipoDeServicio);
    public void retirarEfectivo(Double monto);

}
