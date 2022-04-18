package com.company;

import com.company.entity.Booking;
import com.company.entity.BookingType;
import com.company.entity.Client;
import com.company.entity.Locator;
import com.company.repository.ClientRepository;
import com.company.repository.LocatorRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Crear Mapas en Memoria para la 'Persistencia'
        Map<Integer, Locator> locatorMap = new HashMap<>();
        Map<String, Client> clientMap = new HashMap<>();

        // Crear Repositorios
        LocatorRepository locatorRepository = new LocatorRepository(locatorMap);
        ClientRepository clientRepository = new ClientRepository(clientMap, locatorRepository);

        // Crear clientes
        Client client1 = new Client("Pepito", "Perez", "1234");
        Client client2 = new Client("Maria", "Milagros", "98766");
        clientRepository.addClient(client1);

        // Crear Reservas
        Booking hotel = new Booking(1, BookingType.HOTEL, 100F, 0F);
        Booking ticket = new Booking(2, BookingType.TICKET, 50F, 0F);
        Booking restaurant = new Booking(3, BookingType.RESTAURANT, 30F, 0F);
        Booking road = new Booking(4, BookingType.ROAD, 100F, 0F);

        // Crear paquetes
        List<Booking> packageFull = new ArrayList<>();
        packageFull.add(hotel);
        packageFull.add(ticket);
        packageFull.add(restaurant);
        packageFull.add(road);


        List<Booking> package1b = new ArrayList<>();
        package1b.add(hotel);
        package1b.add(hotel);
        package1b.add(ticket);
        package1b.add(ticket);

        List<Booking> package1c = new ArrayList<>();
        package1b.add(restaurant);

        // Crear Localizadores
        Locator locator1 = new Locator(1, client1, packageFull); // punto 1-a
        Locator locator2 = new Locator(2, client1, package1b); // punto 1-b
        Locator locator3 = new Locator(3, client1, package1c); // punto 1-c

        locatorRepository.addLocator(locator1);
        locatorRepository.addLocator(locator2);
        locatorRepository.addLocator(locator3);


    }
}
