package Ejercicio1;

public interface Transferencia extends Transaccion{
    void realizarTransferencia(int monto, String destino);
}
