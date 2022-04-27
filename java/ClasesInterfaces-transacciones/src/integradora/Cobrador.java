package integradora;

public class Cobrador extends TransaccionMinima implements Transaccion{

    @Override
    public void transaccionOK() {
        System.out.println("Cliente Cobrador, transacción exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cliente Cobrador, transacción exitosa.");
    }
}
