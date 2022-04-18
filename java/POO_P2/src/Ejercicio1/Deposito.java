package Ejercicio1;

public interface Deposito extends Transacciones {
    @Override
    default void transaccionOk() {
        System.out.println("Realizando deposito...");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Realizando deposito...");
    }
}
