package interfaces;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito --> OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Realizando deposito --> ERROR");
    }
}
