package com.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Ejecutivos ejec = new Ejecutivos();
        ejec.ejecutarDepósito();
        ejec.ejecutarTransferencia();
        System.out.println("------------------");

        Cobradores cobradores = new Cobradores();
        cobradores.consultarSaldo();
        cobradores.retirarDinero();
        System.out.println("------------------");

        Basicos basic = new Basicos();
        basic.consultaDeSaldo();
        basic.depositarDinero();

    }
}
