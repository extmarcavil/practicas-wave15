import repository.ClientRepository;
import model.Client;
import service.ClientService;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ClientRepository repository = ClientRepository.getInstance();
        ClientService clientService = ClientService.getInstance();

        Client[] clients = Stream.of(
                new Client("33334434", "pepe", "elpepe"),
                new Client("23232222", "ramiro", "rama"),
                new Client("23233677", "olivia", "oli")
        ).toArray(Client[]::new);

        repository.save(clients);
        clientService.printClients();
        repository.delete(clients[2]);
    }

}
