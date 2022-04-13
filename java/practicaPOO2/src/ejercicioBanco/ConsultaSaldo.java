package ejercicioBanco;

public class ConsultaSaldo extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta de saldo falló.");
    }
}
