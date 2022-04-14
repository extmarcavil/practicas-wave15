package Ejercicio1;

public class Ejecutivos implements Transaccion {

    public String Deposito(){
        return "Se realizó el depósito.";
    }

    public String Transferencia () {
        return "Se realizó la transferencia.";
    }

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
