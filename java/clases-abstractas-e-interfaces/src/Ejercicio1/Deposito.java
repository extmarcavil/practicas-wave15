package Ejercicio1;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito fallido.");
    }
}
