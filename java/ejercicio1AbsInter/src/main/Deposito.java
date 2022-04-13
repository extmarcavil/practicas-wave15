package main;

public interface Deposito extends Transaccion{

    default void realizarDeposito(){
        System.out.println("Realizando depósito...");
    }

}
