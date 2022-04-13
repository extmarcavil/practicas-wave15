package main;

public interface Transaccion {

    default void transaccionOk(){
        System.out.println("Transacción realizada con éxito.");
    };
    default void transaccionNoOk(){
        System.out.println("Ocurrió un error. Transacción no realizada.");
    };

}
