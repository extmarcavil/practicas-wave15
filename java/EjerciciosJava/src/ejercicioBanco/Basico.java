package ejercicioBanco;

public class Basico extends Cliente {
    public void consultarSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo();
    }

    @Override
    public <T> void realizarTransaccion(T transaccion) {
        if (transaccion.getClass().equals(ConsultaSaldo.class)) {
            if (this.transacciones.add(transaccion)) {
                ((ConsultaSaldo) transaccion).transaccionOk();
            } else {
                ((ConsultaSaldo) transaccion).transaccionNoOk();
            }
        } else if (transaccion.getClass().equals(PagoServicio.class)) {
            if (this.transacciones.add(transaccion)) {
                ((PagoServicio) transaccion).transaccionOk();
            } else {
                ((PagoServicio) transaccion).transaccionNoOk();
            }
        } else if (transaccion.getClass().equals(RetiroEfectivo.class)) {
            if (this.transacciones.add(transaccion)) {
                ((RetiroEfectivo) transaccion).transaccionOk();
            } else {
                ((RetiroEfectivo) transaccion).transaccionNoOk();
            }
        } else {
            System.out.println("Transaccion no permitida");
        }
    }
}
