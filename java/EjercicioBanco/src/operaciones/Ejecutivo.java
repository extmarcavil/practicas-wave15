package operaciones;

import transacciones.Transaccion;

public class Ejecutivo implements Cliente {

    @Override
    public void realizarDeposito(Transaccion deposito) {
        deposito.transaccionOk();
    }

    @Override
    public void realizarTransferencia(Transaccion transferencia) {
        transferencia.transaccionOk();
    }

    @Override
    public void realizarConsultaSaldo(Transaccion consulta) {
        consulta.transaccionNoOk();
    }

    @Override
    public void realizarPagoServicio(Transaccion pagoServicios) {
        pagoServicios.transaccionNoOk();
    }

    @Override
    public void realizarRetiroDeEfectivo(Transaccion retiroEfecivo) {
        retiroEfecivo.transaccionNoOk();
    }
}
