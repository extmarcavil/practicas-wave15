package ejercicioBanco;

public class RetiroEfectivo extends Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retido de efectivo exitoso.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro de efectivo falló.");
    }
}
