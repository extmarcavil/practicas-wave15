package main;

public interface Transferencia extends Transaccion{

    default void realizarTransferencia(){
        System.out.println("Realizando transferencia...");
    }

}
