package ejercicio1;

public class Ejecutivos implements Deposito, Transferencia {
    @Override
    public void depositar() {
        System.out.println("Realizando deposito...");
        transaccionOk();
    }

    @Override
    public void transferir() {
        System.out.println("Realizando transferencia...");
        transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transaccion se ha realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo realizar");
    }

}
