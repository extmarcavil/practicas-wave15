package EjercicioPracticoClasesAbstractasEInterfaces.Banco;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consulta saldo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Ok");
    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void retirarEfectivo() {

    }
}
