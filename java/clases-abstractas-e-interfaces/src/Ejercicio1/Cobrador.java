package Ejercicio1;

public class Cobrador extends Cliente {
    @Override
    public void consultarSaldo() {
        this.consultaSaldo.transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        this.retiroEfectivo.transaccionOk();
    }
}
