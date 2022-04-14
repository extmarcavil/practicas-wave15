package com.company;

public interface Banco {

    public void deposito();
    public void transferencia(String estado);
    public void retiroEfectivo();
    public void consultaSaldo();
    public void pagodeServicios();
}
