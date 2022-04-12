package clases;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicio;
import interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public String consultarSaldo() {
        return null;
    }

    @Override
    public void transaccionOk(String tipoTransacc) {

    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {

    }

    @Override
    public String pagarServicio() {
        return null;
    }

    @Override
    public String retirarEfectivo(Double monto) {
        return null;
    }
}
