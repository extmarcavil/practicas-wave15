package abstraccionPractico;

public class Basico implements ConsultaDeSaldo,PagoDeServicios,RetiroEfectivo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizando Retiro");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un problema en la transaccion");

    }
}
