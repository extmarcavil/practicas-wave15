package Ejercicio1;

public class Cobradores implements Transaccion{

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

}
