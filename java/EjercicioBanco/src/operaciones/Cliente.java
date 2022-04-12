package operaciones;

import transacciones.Transaccion;

public interface Cliente {
    public void realizarDeposito(Transaccion t);
    public void realizarTransferencia(Transaccion t);
    public void realizarConsultaSaldo(Transaccion t);
    public void realizarPagoServicio(Transaccion t);
    public void realizarRetiroDeEfectivo(Transaccion t);
}
