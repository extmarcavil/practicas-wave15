package com.bootcamp.interfaces;

public interface ITransaccion {


    public abstract void transaccionOk(String tipoTransacc);
    public abstract void transaccionNoOk(String tipoTransacc);


}
