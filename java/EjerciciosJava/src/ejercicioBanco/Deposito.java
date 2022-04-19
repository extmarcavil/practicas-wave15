package ejercicioBanco;

public class Deposito implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("El deposito fue exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El deposito no fue realizado");
    }
}
