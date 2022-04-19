package ejercicioBanco;

public class PagoServicio implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Pago realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo efectuar el pago");
    }
}
