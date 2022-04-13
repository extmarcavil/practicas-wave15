package transaccionesBanco;

public class Ejecutivo extends Cliente{


    public Ejecutivo(int saldo, String cbu) {
        super(saldo, cbu);
    }

    public void realizarDeposito(){
        System.out.println("Realizando deposito...");
        transaccionOk();
    }

    public void realizarTransferencia(){
        System.out.println("Realizando transferencia...");
        transaccionOk();
    }
}
