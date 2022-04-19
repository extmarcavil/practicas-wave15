package ejercicioBanco;

public class Ejecutivo extends Cliente {
    @Override
    public <T> void realizarTransaccion(T transaccion) {
        if (transaccion.getClass().equals(Deposito.class)) {
            if (this.transacciones.add(transaccion)) {
                ((Deposito) transaccion).transaccionOk();
            } else {
                ((Deposito) transaccion).transaccionNoOk();
            }
        } else if (transaccion.getClass().equals(Transferencia.class)) {
            if (this.transacciones.add(transaccion)) {
                ((Transferencia) transaccion).transaccionOk();
            } else {
                ((Transferencia) transaccion).transaccionNoOk();
            }
        } else {
            System.out.println("Transaccion no permitida");
        }

    /*public void realizarDeposito() {
        Deposito deposito = new Deposito();
        if(this.transacciones.add(deposito)){
            deposito.transaccionOk();
        } else {
            deposito.transaccionNoOk();
        }
    }

    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        if(this.transacciones.add(transferencia)) {
            transferencia.transaccionOk();
        } else {
            transferencia.transaccionNoOk();
        }
    }*/
    }
}
