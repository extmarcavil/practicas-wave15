package com.company;

import com.company.Repository.ClienteRepository;

public class Main {

    public static void main(String[] args) {
        Client client = new Client("alejandro", "aguilar", "8989890");
        client.setBookings(BOOKING.HOTEL_BOOKING,1);
        client.setBookings(BOOKING.TRANSPORT,1);
        client.setBookings(BOOKING.TRAVEL_TIQUET,1);
        client.setBookings(BOOKING.FOOD,1);

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.setClientList(client);
        clienteRepository.showClientsInfo();

    }
}
