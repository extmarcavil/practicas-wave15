package agencyTurism.repository;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Reserva;

import java.util.List;

public interface ClienteRepository {

    void saveClient(Cliente cliente);

    List<Reserva> getReservas(Cliente cliente);
}
