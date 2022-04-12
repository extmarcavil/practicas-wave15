package Ejercicio1;

public abstract class Cliente {
    protected Deposito deposito;
    protected ConsultaSaldo consultaSaldo;
    protected RetiroEfectivo retiroEfectivo;
    protected Transferencia transferencia;
    protected PagoServicios pagoServicios;

    public Cliente() {
        this.deposito = new Deposito();
        this.consultaSaldo = new ConsultaSaldo();
        this.retiroEfectivo = new RetiroEfectivo();
        this.transferencia = new Transferencia();
        this.pagoServicios = new PagoServicios();
    }

    public void depositar() {
        deposito.transaccionNoOk();
    }
    public void consultarSaldo() {
        consultaSaldo.transaccionNoOk();
    }
    public void retirarEfectivo() {
        retiroEfectivo.transaccionNoOk();
    }
    public void transferir() {
        transferencia.transaccionNoOk();
    }
    public void pagarServicios() {
        pagoServicios.transaccionNoOk();
    }
}
