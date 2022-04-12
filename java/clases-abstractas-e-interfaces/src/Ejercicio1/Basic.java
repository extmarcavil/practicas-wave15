package Ejercicio1;

public class Basic extends Cliente {
    @Override
    public void consultarSaldo() {
        this.consultaSaldo.transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        this.retiroEfectivo.transaccionOk();
    }

    @Override
    public void pagarServicios() {
        this.pagoServicios.transaccionOk();
    }
}
