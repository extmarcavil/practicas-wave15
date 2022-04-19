package ejercicioBanco;

public class ConsultaSaldo implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la consulta solicitada");
    }
}
