package com.company;

public abstract class Transaccion {

    public void transaccionOk(){
        System.out.println("Transaccion Exitosa");
    }

    public void transaccionesNoOk(){
        System.out.println("Transaccion No exitosa, el Cliente no tiene acceso a esta funcionalidad");
    }
}
