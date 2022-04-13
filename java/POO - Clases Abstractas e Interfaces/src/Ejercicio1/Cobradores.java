package Ejercicio1;

public class Cobradores extends Banco implements Transaccion{

    public Cobradores() {}

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion + " se ha realizado correctamente.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion + " no se pudo realizar.");
    }

    @Override
    void consultaSaldo() {
        System.out.println("Consultando saldo...");
        transaccionOk("consulta de saldos");
    }

    @Override
    void depositos() {
        transaccionNoOk("depositos");
    }

    @Override
    void transferencias() {
        transaccionNoOk("transferencias");
    }

    @Override
    void pagoServicios() {
        transaccionNoOk("pago de servicios");
    }

    @Override
    void retiroEfectivo() {
        System.out.println("Retiro de efectivo...");
        transaccionOk("retiro de efectivo");
    }
}
