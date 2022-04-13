package main;

public interface PagoDeServicio extends Transaccion{

    default void realizarPagoDeServicio(){
        System.out.println("Realizando pago de servicio...");
    }

}
