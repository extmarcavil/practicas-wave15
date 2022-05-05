package ejercicio1.transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOK() {
        System.out.println("La transferencia se ha realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Han habido errores a la hora de realizar la transferencia");
    }
}
