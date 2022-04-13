package com.company;

public class Main {

    public static void main(String[] args) {
	    Auto a = new Auto(2.5f, 2.5f, 45, "52AKMB");
        Carrera c = new Carrera(200, 10000, "Grand Prix", 2);
        c.darDeAlta(a);

        c.socorrerAuto("52AKMB"); // Alternativa: Socorrista.socorrer(a);

        System.out.println("Ganador: " + c.definirGanador());

        c.eliminar(a);
        c.eliminar("0AS92S");
    }
}
