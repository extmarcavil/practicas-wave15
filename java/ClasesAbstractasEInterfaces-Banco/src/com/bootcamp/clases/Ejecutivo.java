package com.bootcamp.clases;

import com.bootcamp.interfaces.IDeposito;
import com.bootcamp.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Intentando realizar depósito...");
    /*Acá incluso se puede poner un if....
      if deposito == true, llama a transaccion ok, else llama a transaccion no ok (por ejemplo)
      * */
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo realizar.");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando realizar transferencia...");

        /*Acá incluso se puede poner un if....
      if transferencia == true, llama a transaccion ok, else llama a transaccion no ok (por ejemplo)
      * */

    }
}
