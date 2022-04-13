package main;

public interface RetiroDeEfectivo extends Transaccion{

    default void retirarEfectivo(){
        System.out.println("Realizando retiro de efectivo...");
    }

}
