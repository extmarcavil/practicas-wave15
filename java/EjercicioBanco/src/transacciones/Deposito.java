package transacciones;

import transacciones.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito completado exitosamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no permitida.");
    }
}
