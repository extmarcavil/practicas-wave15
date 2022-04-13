package ejercicioBanco;

public class RetiroEfectivo implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el retiro de efectivo");
    }
}
