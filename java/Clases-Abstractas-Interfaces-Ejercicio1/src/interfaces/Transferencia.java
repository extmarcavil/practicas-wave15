package interfaces;

public class Transferencia implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia --> OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Realizando transferencia --> ERROR");
    }
}
