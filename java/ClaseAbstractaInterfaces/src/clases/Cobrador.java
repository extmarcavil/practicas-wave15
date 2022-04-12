package clases;

import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public String retirarEfectivo(Double monto) {
        return "intentando retirar $"+monto;
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc+" Realizada");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("Error,  el tipo de transaccion: '"+tipoTransacc+"' no se pudo realizar");
    }

    @Override
    public String consultarSaldo() {
        return "Consultando saldo...";
    }


}
