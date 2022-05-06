package com.company;

public interface Operaciones {

    public String realizarDeposito(Transaccion t);
    public String realizarTransferencia(Transaccion t);
    public String consultarSaldo(Transaccion t);
    public String relizarPagoDeServicio(Transaccion t);
    public String retirarEfectivo(Transaccion t);

}
