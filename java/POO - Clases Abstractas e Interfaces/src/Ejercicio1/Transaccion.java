package Ejercicio1;

public interface Transaccion {
    void transaccionOk(String tipoTransaccion);
    void transaccionNoOk(String tipoTransaccion);
}
