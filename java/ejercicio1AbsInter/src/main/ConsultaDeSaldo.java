package main;

public interface ConsultaDeSaldo extends Transaccion{

    default void consultarSaldo(){
        System.out.println("Realizando consulta de saldo...");
    }
}
