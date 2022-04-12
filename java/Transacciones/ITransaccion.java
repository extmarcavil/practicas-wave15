package Transacciones;

public interface ITransaccion {
    void transaccionOk(String tipo);
    void transaccionNoOk(String tipo);
}
