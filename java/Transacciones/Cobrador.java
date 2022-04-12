package Transacciones;

public class Cobrador implements IRetiroEfectivo, IConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println(tipo + " relizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no pudo ser realizada");
    }
}
