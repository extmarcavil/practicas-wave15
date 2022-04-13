import models.Cliente;
import models.Localizador;
import repositories.EntityRepository;

import java.util.function.Predicate;

public class AgenciaDeViajes {
    private final EntityRepository<Localizador> localizadores;
    private final EntityRepository<Cliente> clientes;

    public AgenciaDeViajes() {
        this.localizadores = new EntityRepository<>();
        this.clientes = new EntityRepository<>();
    }

    public void addCliente(Cliente cliente) {
        this.clientes.save(cliente);
    }

    public void imprimirLocalizadores() {
        this.localizadores
                .findAll()
                .forEach(Localizador::imprimir);
    }

    public void addLocalizador(Localizador localizador) {
        // agrego cliente si aun no existe
        if (!this.clientes.existsById(localizador.getCliente().getId())) {
            localizador.setCliente(
                    this.clientes.save(localizador.getCliente())
            );
        }
        Long idCliente = localizador.getCliente().getId();
        System.out.println("## Agregando nuevo localizador al cliente con id " + idCliente);

        // descuentos
        if (this.clienteConMasDeDosLocalizadores(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.95);
            System.out.println("Se aplico el descuento 1 al cliente con id " + idCliente);
        }
        if (this.clienteConPaqueteCompleto(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.90);
            System.out.println("Se aplico el descuento 2 al cliente con id " + idCliente);
        }
        if (this.clienteConDosReservasDeHotel(localizador) || this.clienteConDosBoletosDeViaje(localizador)) {
            localizador.setTotal(localizador.getTotal() * 0.95);
            System.out.println("Se aplico el descuento 3 al cliente con id " + idCliente);
        }

        // agrego localizador
        this.localizadores.save(localizador);

        System.out.println("-- Fin agregar localizador");
        System.out.println("");
    }

    private boolean clienteConDosBoletosDeViaje(Localizador localizador) {
        Long idCliente = localizador.getCliente().getId();
        return this.clienteConCondicionMayorA(
                l -> l.getCliente().getId().equals(idCliente) && l.hasBoletoDeViaje(),
                1
        );
    }

    private boolean clienteConDosReservasDeHotel(Localizador localizador) {
        Long idCliente = localizador.getCliente().getId();
        return this.clienteConCondicionMayorA(
                l -> l.getCliente().getId().equals(idCliente) && l.hasReservaDeHotel(),
                1
        );
    }

    private boolean clienteConMasDeDosLocalizadores(Localizador localizador) {
        String dniCliente = localizador.getCliente().getDni();
        return this.clienteConCondicionMayorA(
                l -> l.getCliente().getDni().equals(dniCliente),
                1
        );
    }

    private boolean clienteConPaqueteCompleto(Localizador localizador) {
        return this.clienteConCondicionMayorA(
                Localizador::hasReservaCompleta,
                0
        );
    }

    private boolean clienteConCondicionMayorA(Predicate<Localizador> filterFun, Integer number) {
        return this.localizadores
                .findAll()
                .stream()
                .filter(filterFun)
                .count() > number;
    }
}
