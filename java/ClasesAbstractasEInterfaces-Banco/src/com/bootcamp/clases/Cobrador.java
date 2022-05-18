package com.bootcamp.clases;

import com.bootcamp.interfaces.IConsultaSaldo;
import com.bootcamp.interfaces.IRetiroEfec;

public class Cobrador implements IRetiroEfec, IConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        /*Acá incluso se puede poner un if....
      if salio todo ok, llama a transaccion ok, else llama a transaccion no ok (por ejemplo)
      * */
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Intentando retirar: " + monto);
        /*Acá incluso se puede poner un if....
      if salio todo ok, llama a transaccion ok, else llama a transaccion no ok (por ejemplo)
      * */
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente.");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo realizar");
    }
}
