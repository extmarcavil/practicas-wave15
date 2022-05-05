package ejercicio1.transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOK() {
        System.out.println("El retiro se ha realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Han habido errores a la hora de realizar el retiro");
    }
}
