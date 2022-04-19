package agencyTurism.services;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Localizador;
import agencyTurism.entity.Reserva;

import java.util.List;

public interface DataService {

    void saveClient(Cliente cliente);
    void saveLocalizador(Localizador localizador);

    List<Reserva> getReservas(Cliente cliente);
}
