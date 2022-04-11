package interfaces;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo --> OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Realizando retiro de efectivo --> ERROR");
    }
}
