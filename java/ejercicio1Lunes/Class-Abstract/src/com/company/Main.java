package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //Punto 1
        /**
         * Transferencias

         Transaccion depositar = new Depositar();
         Transaccion transferir = new Transferir();
         Transaccion consultar = new ConsultarSaldo();
         Transaccion pagoServicio = new PagoDeServicios();
         Transaccion retirar = new Retirar();

         /**
         * Clientes

         Cliente clienteEjecutivo = new Ejecutivo();
         Cliente clienteBasico = new Basic();
         Cliente clienteCobradores = new Cobradore();

         clienteEjecutivo.Depositar(depositar);
         clienteEjecutivo.consultarSaldo(consultar);

         clienteBasico.Depositar(depositar);
         */

        /***********************************************/
        //Punto 2

        Curriculum curriculum = new Curriculum("Pedro");

        Pdf pdf1 = new Pdf(10, 200, "Pedro", "Libroxx", "Suspenso");

        Informes informe = new Informes("hbdfbwd", 200, "Juan", "Pedro");

        Imprimir.imprimir(informe);


    }
}
