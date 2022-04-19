package ejercicioBanco;

public class Cobrador extends Cliente {
    @Override
    public <T> void realizarTransaccion(T transaccion) {
        if (transaccion.getClass().equals(RetiroEfectivo.class)) {
            if (this.transacciones.add(transaccion)) {
                ((RetiroEfectivo) transaccion).transaccionOk();
            } else {
                ((RetiroEfectivo) transaccion).transaccionNoOk();
            }
        } else if (transaccion.getClass().equals(ConsultaSaldo.class)) {
            if (this.transacciones.add(transaccion)) {
                ((ConsultaSaldo) transaccion).transaccionOk();
            } else {
                ((ConsultaSaldo) transaccion).transaccionNoOk();
            }
        } else {
            System.out.println("Transaccion no permitida");
        }
    }
}
