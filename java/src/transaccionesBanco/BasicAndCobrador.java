package transaccionesBanco;

public class BasicAndCobrador extends Cliente{

    public BasicAndCobrador(int saldo, String cbu) {
        super(saldo, cbu);
    }

    public void consultarSaldo(){
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    public void retirarEfectivo(){
        System.out.println("Retirando efectivo...");
        transaccionOk();
    }

}
