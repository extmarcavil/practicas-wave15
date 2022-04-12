package operaciones;

import transacciones.Transaccion;

public class Basic implements Cliente {

    @Override
    public void realizarDeposito(Transaccion deposito) {
        deposito.transaccionNoOk();
    }

    @Override
    public void realizarTransferencia(Transaccion transferencia) {
        transferencia.transaccionNoOk();
    }

    @Override
    public void realizarConsultaSaldo(Transaccion consulta) {
        consulta.transaccionOk();
    }

    @Override
    public void realizarPagoServicio(Transaccion pagoServicios) {
        pagoServicios.transaccionOk();
    }

    @Override
    public void realizarRetiroDeEfectivo(Transaccion retiroEfecivo) {
        retiroEfecivo.transaccionOk();
    }
}
