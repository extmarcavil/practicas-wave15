package exception;

import model.Client;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Client client) {
        super(String.format("The Client = [%s] wasn't found", client));
    }

    public ClientNotFoundException(String dni) {
        super(String.format("Client with DNI %s wasn't found", dni));
    }
}
