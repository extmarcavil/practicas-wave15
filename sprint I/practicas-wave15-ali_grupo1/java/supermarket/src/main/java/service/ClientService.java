package service;

import exception.ClientNotFoundException;
import model.Client;
import model.Invoice;
import model.Item;
import repository.ClientRepository;
import repository.InvoiceRepository;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository = ClientRepository.getInstance();
    private final InvoiceRepository invoiceRepository = InvoiceRepository.getInstance();
    private static ClientService clientService;

    public void createInvoice(Client client, Item... items) {
        clientRepository.findByDni(client.getDni())
                .ifPresentOrElse(clientPresent -> {
                    List<Item> itemsToSave = List.of(items);
                    Invoice invoice =  Invoice.from(client, itemsToSave, calculateAmount(itemsToSave));
                    invoiceRepository.save(invoice);
                    System.out.println("Invoice created successfully");
                }, () -> {
                    clientRepository.save(client);
                    System.out.println("Client doesn't exist so it's saved successfully in database");
                });
    }

    private double calculateAmount(List<Item> itemsToSave) {
        return itemsToSave.stream()
                .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                .reduce(0, Double::sum);
    }

    public void findByDni(String dni) {
        clientRepository.findByDni(dni)
                .ifPresentOrElse(
                        System.out::println,
                        () -> {
                            throw new ClientNotFoundException(dni);
                        }
                );
    }

    public void printClients() {
        clientRepository.getAll().forEach(System.out::println);
    }

    public static ClientService getInstance() {
        return clientService = clientService == null ? new ClientService() : clientService;
    }

}
