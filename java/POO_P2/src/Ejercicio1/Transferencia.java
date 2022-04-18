package Ejercicio1;

public interface Transferencia extends Transacciones {
    @Override
    default void transaccionOk() {
        System.out.println("Ejecutando transferencia...");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Transferencia fallida.");
    }
}
