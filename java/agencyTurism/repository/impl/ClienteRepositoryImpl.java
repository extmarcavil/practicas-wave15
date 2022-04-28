package agencyTurism.repository.impl;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Reserva;
import agencyTurism.repository.ClienteRepository;
import agencyTurism.services.DataService;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    private DataService dataService;

    public ClienteRepositoryImpl(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void saveClient(Cliente cliente) {
        this.dataService.saveClient(cliente);
    }

    @Override
    public List<Reserva> getReservas(Cliente cliente) {
        return this.dataService.getReservas(cliente);
    }
}
