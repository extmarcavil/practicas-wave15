package ejercicio1;

public class Basico implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando el saldo...");
        transaccionNoOk();
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios...");
        transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
        transaccionOk();
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
