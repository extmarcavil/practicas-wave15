package ejercicio1.transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOK() {
        System.out.println("La consulta se ha realizado satisfactoriamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Han habido errores a la hora de realizar la consulta");
    }
}
