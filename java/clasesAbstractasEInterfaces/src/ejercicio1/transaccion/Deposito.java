package ejercicio1.transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOK() {
        System.out.println("El deposito se ha realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Han habido errores a la hora de realizar el deposito");
    }
}
