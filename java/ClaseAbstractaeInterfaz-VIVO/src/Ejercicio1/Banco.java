package Ejercicio1;

public class Banco implements Transaccion{

    public String saldo() {
        return "Saldo: ...";
    }
    public String pago_servicios() {
        return "Se abonaron los servicios.";
    }
    public String retiro_efto() {
        return "Se retiro: ...";
    }
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
