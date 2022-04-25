package Ejercicio1;


//Cobradores: Realizan retiro de efectivo y consulta de saldos.
public class Cobrador extends User implements Retiro, ConsultaSaldo{


    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO exitosa");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo");
    }

    @Override
    public void retirar() {
        System.out.println("Retirando dinero");
    }
}
