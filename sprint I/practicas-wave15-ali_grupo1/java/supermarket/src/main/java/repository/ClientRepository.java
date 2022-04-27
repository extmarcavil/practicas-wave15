package repository;

import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements GenericRepository<Long, Client> {

    private static ClientRepository repository;

    public static ClientRepository getInstance() {
        return repository = repository == null ? new ClientRepository() : repository;
    }

    private static final List<Client> clients = new ArrayList<>();

    public Optional<Client> findByDni(String dni) {
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public void save(Client entity) {
        clients.add(entity);
    }

    @Override
    public void save(Client... entity) {
        clients.addAll(List.of(entity));
    }

    @Override
    public void delete(Client entity) {
        clients.remove(entity);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public boolean exists(Client entity) {
        return clients.contains(entity);
    }

}
