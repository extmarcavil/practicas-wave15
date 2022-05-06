package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Transacciones que se pueden realizar.
         */
        Transaccion depositar = new Deposito();
        Transaccion transferir = new Transferencia();
        Transaccion consultar = new ConsultaDeSaldo();
        Transaccion pagoServicio = new PagoDeServicio();
        Transaccion retirar = new RetiroDeEfectivo();


        /**
         * Clientes del Banco que realizan los distintas Operaciones.
         */
        ClienteBasic clienteBasico = new ClienteBasic();
        ClienteEjecutivo clienteEjecutivo = new ClienteEjecutivo();
        ClienteCobrador clienteCobrador = new ClienteCobrador();

        /**
         * Operaciones realizadas por los clientes Basic.
         */
        System.out.println(clienteBasico.consultarSaldo(depositar)); //Transaccion no corresponde a lo que el cliente desea hacer.
        System.out.println(clienteBasico.consultarSaldo(consultar));
        System.out.println(clienteBasico.realizarTransferencia(transferir));//La operacion no es valida para este cliente.


        /**
         * Operaciones realizadas por Clientes Ejecutivos.
         */
        System.out.println(clienteEjecutivo.relizarPagoDeServicio(transferir)); //Transaccion no corresponde a lo que el cliente desea hacer.
        System.out.println(clienteEjecutivo.realizarTransferencia(transferir));
        System.out.println(clienteEjecutivo.consultarSaldo(consultar));//La operacion no es valida para este cliente.


        /**
         * Operaciones realizadas por Clientes Cobradores.
         */
        System.out.println(clienteCobrador.retirarEfectivo(pagoServicio)); //Transaccion no corresponde a lo que el cliente desea hacer.
        System.out.println(clienteCobrador.retirarEfectivo(retirar));
        System.out.println(clienteCobrador.realizarTransferencia(transferir));//La operacion no es valida para este cliente.


    }
}
