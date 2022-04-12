package Ejercicio1;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Calculando saldo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No tiene acceso a esta consulta.");
    }
}
