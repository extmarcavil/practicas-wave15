package Ejercicio1;

public class Basico extends Banco implements Transaccion{

    private boolean saldo;
    private double efectivo;

    public boolean isSaldo() {
        return saldo;
    }

    public void setSaldo(boolean saldo) {
        this.saldo = saldo;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public Basico(boolean saldo, double efectivo) {
        this.efectivo = efectivo;
        this.saldo = saldo;
    }


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
        if (saldo == true)
            transaccionOk("consulta de saldo");
        else
            transaccionNoOk("consulta de saldo");
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
        transaccionOk("pago de servicios");
    }

    @Override
    void retiroEfectivo() {
        transaccionOk("retiro de efectivo");
    }
}
