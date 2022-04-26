package interfaces;

public class ConsultaSaldo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando Consulta --> OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Realizando Consulta --> ERROR");
    }
}
