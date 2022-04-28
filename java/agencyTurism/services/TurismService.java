package agencyTurism.services;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Localizador;
import agencyTurism.entity.Reserva;

import java.util.List;

public interface TurismService {

    void saveLocalizador(Localizador localizador);
    List<Reserva> getReservasDeCliente(Cliente cliente);
}
