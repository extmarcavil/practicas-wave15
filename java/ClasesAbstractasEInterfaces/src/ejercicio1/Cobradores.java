package ejercicio1;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
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
