package POO_ClasesAbastractasInterfaces.Banco;

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

    public abstract void depositar();
    public abstract void transferencia();
    public abstract void retiroEfectivo();
    public abstract void consultaSaldo();
    public abstract void PagoServicios();
}
