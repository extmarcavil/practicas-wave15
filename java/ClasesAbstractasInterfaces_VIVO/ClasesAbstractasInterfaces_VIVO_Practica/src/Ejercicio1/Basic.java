package Ejercicio1;



//Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
public class Basic extends User implements ConsultaSaldo, Pagos, Retiro{


    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios");
    }

    @Override
    public void retirar() {
        System.out.println("Retirando dinero");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO exitosa");
    }
}
