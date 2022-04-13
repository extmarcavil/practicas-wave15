package database;

import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDatabase {

    private static final List<Client> clients = new ArrayList<>();

    public static void saveClient(Client... client) {
        clients.addAll(List.of(client));
    }

    public static List<Client> getAll() {
        return clients;
    }

    public static void deleteClient(Client client) {
        clients.remove(client);
    }

    public static Optional<Client> findByDni(String dni) {
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst();
    }
}
