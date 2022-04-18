package repository;

import exception.ClientNotFoundException;
import model.Client;
import model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceRepository implements GenericRepository<Long, Invoice> {

    private static InvoiceRepository repository;

    public static InvoiceRepository getInstance() {
        return repository = repository == null ? new InvoiceRepository() : repository;
    }

    private static final List<Invoice> invoices = new ArrayList<>();

    @Override
    public void save(Invoice entity) {
        invoices.add(entity);
    }

    @Override
    public void save(Invoice... entity) {
        invoices.addAll(List.of(entity));
    }

    @Override
    public void delete(Invoice entity) {
        invoices.remove(entity);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Invoice> getAll() {
        return invoices;
    }

    @Override
    public boolean exists(Invoice entity) {
        return invoices.contains(entity);
    }

    public Invoice findByClient(Client client) {
        return invoices.stream()
                .filter(invoice -> invoice.getClient().equals(client))
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException(client));
    }
}
