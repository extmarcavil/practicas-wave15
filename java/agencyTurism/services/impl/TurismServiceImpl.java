package agencyTurism.services.impl;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Localizador;
import agencyTurism.entity.Reserva;
import agencyTurism.repository.ClienteRepository;
import agencyTurism.repository.LocalizadorRepository;
import agencyTurism.services.TurismService;

import java.util.List;

public class TurismServiceImpl implements TurismService {

    private ClienteRepository clienteRepository;
    private LocalizadorRepository localizadorRepository;

    public TurismServiceImpl(ClienteRepository clienteRepository, LocalizadorRepository localizadorRepository) {
        this.clienteRepository = clienteRepository;
        this.localizadorRepository = localizadorRepository;
    }

    @Override
    public void saveLocalizador(Localizador localizador) {
        this.localizadorRepository.saveLocalizador(localizador);
    }

    @Override
    public List<Reserva> getReservasDeCliente(Cliente cliente) {
        return this.clienteRepository.getReservas(cliente);
    }
}
