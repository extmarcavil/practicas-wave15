import database.ClientDatabase;
import model.Client;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Client[] clients = Stream.of(
                new Client("33334434", "pepe", "elpepe"),
                new Client("23232222", "ramiro", "rama"),
                new Client("23233677", "olivia", "oli")
        ).toArray(Client[]::new);

        ClientDatabase.saveClient(clients);

        List<Client> clientList = ClientDatabase.getAll();
        printClients(clientList);
        ClientDatabase.deleteClient(clients[2]);
        printClients(clientList);
        findByDni("33334434");
    }

    public static void printClients(List<Client> clients) {
        clients.forEach(System.out::println);
    }

    public static void findByDni(String dni) {
        ClientDatabase.findByDni(dni)
                .ifPresentOrElse(System.out::println, () -> System.out.printf("Client with DNI %s wasn't found%n", dni));
    }
}
