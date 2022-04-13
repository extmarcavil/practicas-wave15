package Ejercicio1;

public class Ejecutivos extends Banco implements Transaccion {

    public Ejecutivos() {}


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
        transaccionNoOk("consulta de saldos");
    }

    @Override
    void depositos() {
        System.out.println("Consultando depositos...");
        transaccionOk("depositos");
    }

    @Override
    void transferencias() {
        System.out.println("Accediendo a transferencias...");
        transaccionOk("transferencias");
    }

    @Override
    void pagoServicios() {
        transaccionNoOk("pago de servicios");
    }

    @Override
    void retiroEfectivo() {
        transaccionNoOk("retiro de efectivo");
    }
}
