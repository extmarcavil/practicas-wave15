package service;

import exception.ClientNotFoundException;
import model.Client;
import model.Invoice;
import model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import repository.ClientRepository;
import repository.InvoiceRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@RunWith(JUnit4.class)
public class ClientServiceTest {

    private final ClientService clientService = ClientService.getInstance();
    private final ClientRepository clientRepository = ClientRepository.getInstance();
    private final InvoiceRepository invoiceRepository = InvoiceRepository.getInstance();

    private Client client;
    private Item item;

    @Before
    public void setUp() {
        client = new Client("40404545", "Pepe", "Ramirez");
        item = new Item("003A", "Ropa", 2, 140);
        clientRepository.save(client);
    }

    @Test
    public void whenTheClientDoesNotExistToCreateAnInvoice_thenTheInvoiceIsNotSavedButTheClientIs() {
        Client otherClient = new Client("2323232", "Robert", "Enrito");
        clientService.createInvoice(otherClient, item);

        assertThat(clientRepository.findByDni(otherClient.getDni())).hasValueSatisfying(maybeClient ->
                assertThat(maybeClient).usingRecursiveComparison().isEqualTo(otherClient)
        );

        assertThatThrownBy(() -> invoiceRepository.findByClient(otherClient))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("The Client = [%s] wasn't found", otherClient));
    }

    @Test
    public void whenTheClientExistsToCreateAnInvoice_thenTheInvoiceIsGenerated() {
        double theAmountSavedSimple = item.getQuantity() * item.getUnitPrice();
        Invoice invoice = new Invoice(client, List.of(item), theAmountSavedSimple);
        clientService.createInvoice(client, item);

        assertThat(clientRepository.exists(client)).isTrue();
        assertThat(invoiceRepository.exists(invoice)).isTrue();
    }

    @Test
    public void whenTheClientDoesNotExist_thenAnExceptionIsThrown() {
        String nonExistentDNI = "23232322";
        assertThatThrownBy(() -> clientService.findByDni(nonExistentDNI))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("Client with DNI %s wasn't found", nonExistentDNI));
    }

}