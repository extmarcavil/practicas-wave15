package agencia;

import modelos.*;
import repositorio.RepositorioCliente;
import repositorio.RepositorioLocalizador;

import java.util.ArrayList;

public class AgenciaTurismo {
    private RepositorioCliente repositorioCliente;
    private RepositorioLocalizador repositorioLocalizador;

    public AgenciaTurismo(RepositorioCliente repositorioCliente, RepositorioLocalizador repositorioLocalizador) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioLocalizador = repositorioLocalizador;
    }

    public RepositorioCliente getRepositorioCliente() {
        return repositorioCliente;
    }

    public void setRepositorioCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public RepositorioLocalizador getRepositorioLocalizador() {
        return repositorioLocalizador;
    }

    public void setRepositorioLocalizador(RepositorioLocalizador repositorioLocalizador) {
        this.repositorioLocalizador = repositorioLocalizador;
    }

    private void agregarCliente(Cliente cliente) {
        repositorioCliente.agregar(cliente);
    }

    private boolean aplicarDescuentoPor2Localizadores(String documento, ArrayList<Localizador> localizadores) {
        int contador = 0;

        for (Localizador localizador : localizadores) {
            if (documento.equals(localizador.getCliente().getDocumento())) {
                contador++;
            }
            if (contador == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean aplicarDescuentoPorPaqueteCompleto(ArrayList<Producto> productos) {
        boolean reserva = false, comida = false, boletos = false, transporte = false;
        for (Producto p : productos) {
            if (p instanceof ReservaHotel) {
                reserva = true;
            } else if(p instanceof Comida) {
                comida = true;
            } else if(p instanceof BoletosViaje) {
                boletos = true;
            } else {
                transporte = true;
            }

            if (reserva && comida && boletos && transporte) {
                return true;
            }
        }
        return false;
    }

    private boolean aplicarDescuentoPor2ReservasO2Boletos(ArrayList<Producto> productos) {
        int reservas = 0, boletos = 0;
        for (Producto p : productos) {
            if (p instanceof ReservaHotel) {
                reservas++;
            } else if (p instanceof  BoletosViaje) {
                boletos++;
            }
            if (reservas == 2 || boletos == 2) {
                return true;
            }
        }
        return false;
    }

    public void agregarLocalizador(Cliente cliente, ArrayList<Producto> productos) {
        agregarCliente(cliente);

        double total = 0;
        double descuento = 0;

        if (aplicarDescuentoPor2Localizadores(cliente.getDocumento(), repositorioLocalizador.getLocalizadores())) {
            descuento += 0.05;
        }

        if (aplicarDescuentoPorPaqueteCompleto(productos)) {
            descuento += 0.1;
        }

        if (aplicarDescuentoPor2ReservasO2Boletos(productos)) {
            descuento += 0.05;
        }

        for (Producto p : productos) {
            total += p.getCosto();
        }

        total = total - (total * descuento);

        Localizador localizador = new Localizador(cliente, productos, total);

        System.out.println(localizador.getTotal());

        repositorioLocalizador.agregar(localizador);
    }
}
