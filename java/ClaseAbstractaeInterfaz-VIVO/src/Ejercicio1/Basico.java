package Ejercicio1;

public class Basico extends Banco{


    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
