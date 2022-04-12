package transacciones;

import transacciones.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no permitida.");
    }
}
