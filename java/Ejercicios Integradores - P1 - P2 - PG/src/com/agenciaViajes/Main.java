package com.agenciaViajes;

import com.agenciaViajes.model.*;
import com.agenciaViajes.repository.Repository;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        // cantidad de reservas es la suma de reservas en el paquete turistico como hotel y boletos.
        //Punto 1
        PaqueteTuristico paqueteTuristicoCompleto = new PaqueteTuristico(
                1,
                new Hotel("El hotel", 1, 350),
                true,
                new Boleto("Caribe", 1, 100),
                true);
        Cliente cliente = new Cliente("Pedro", "1234");
        Localizador localizador1 = new Localizador("1", 2, cliente, paqueteTuristicoCompleto);
        repository.guardar(localizador1);
        repository.mostrarPorId("1");

        //Punto 2
        PaqueteTuristico paqueteTuristicoMedio = new PaqueteTuristico(2,
                new Hotel("Torre 1", 2, 600),
                false,
                new Boleto("Punta del Este", 2, 300),
                true);
        Localizador localizador2 = new Localizador("2", 4, cliente, paqueteTuristicoMedio);
        repository.guardar(localizador2);
        repository.mostrarPorId("2");

        //Punto 3
        PaqueteTuristico paqueteTuristicoBasico = new PaqueteTuristico(3,
                new Hotel("Torre 2", 1, 200),
                false,
                new Boleto("Punta del Este", 1, 50),
                false);
        Localizador localizador3 = new Localizador("3",1, cliente, paqueteTuristicoBasico);
        repository.guardar(localizador3);
        repository.mostrarPorId("3");

    }
}
