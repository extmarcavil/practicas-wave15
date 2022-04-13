package abstraccionPractico;

public class Cobrador implements RetiroEfectivo,ConsultaDeSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo");
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
