package agencyTurism.services.impl;

import agencyTurism.entity.Cliente;
import agencyTurism.entity.Localizador;
import agencyTurism.entity.Reserva;
import agencyTurism.services.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataServiceImpl implements DataService {

    private List<Localizador> localizadors;
    private List<Cliente> clientes;

    public DataServiceImpl() {
        this.localizadors = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    @Override
    public void saveClient(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public void saveLocalizador(Localizador localizador) {
        this.localizadors.add(localizador);
    }

    @Override
    public List<Reserva> getReservas(Cliente cliente) {
        return this.clientes.stream()
                .filter( cl -> cl.equals(cliente))
                .collect(Collectors.toList()).get(0)
                .getReservas();
    }
}
