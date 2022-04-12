package com.bootcamp.clases;

import com.bootcamp.interfaces.Deposito;
import com.bootcamp.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Intentando hacer depósito...");
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
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");

        /*Acá incluso se puede poner un if....
      if transferencia == true, llama a transaccion ok, else llama a transaccion no ok (por ejemplo)
      * */

    }
}
