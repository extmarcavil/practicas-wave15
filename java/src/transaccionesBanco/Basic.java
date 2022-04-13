package transaccionesBanco;

public class Basic extends BasicAndCobrador{

    public Basic(int saldo, String cbu) {
        super(saldo, cbu);
    }

    public void pagarServicios(){
        System.out.println("Pagando servicios...");
        transaccionOk();
    }

}
