package IntegradoresP1.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Localizador> localizadores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Repositorio() {
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addLocalizador(Localizador localizador) {
        if (this.clienteConMasDeDosLocalizadores(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.95);
        }
        if (this.clienteConPaqueteCompleto(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.90);
        }
        this.localizadores.add(localizador);
    }

    private boolean clienteConPaqueteCompleto(Localizador localizador) {
        return this.localizadores
                .stream()
                .filter(Localizador::hasReservaCompleta)
                .count() > 0;
    }

    private boolean clienteConMasDeDosLocalizadores(Localizador localizador) {
        return this.localizadores
                .stream()
                .filter(l -> l.getCliente().getDni().equals(localizador.getCliente().getDni()))
                .count() > 2;
    }

    public void imprimirLocalizadores() {
        this.localizadores.forEach(Localizador::imprimir);
    }
}
