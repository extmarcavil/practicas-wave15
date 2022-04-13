package transaccionesBanco;

public class Cliente implements Transaccion{

    int saldo;
    String cbu;

    public Cliente(int saldo, String cbu) {
        this.saldo = saldo;
        this.cbu = cbu;
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción NO realizada.");
    }
}
