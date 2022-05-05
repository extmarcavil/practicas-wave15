import reserva.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        List<Reserva> reservas = new ArrayList<>();

        reservas.add(new Hotel(1,1));
        reservas.add(new Comida(1,1));
        reservas.add(new BoletoAvion(1,2));
        reservas.add(new Transporte(1,1));

        Localizador loc = new Localizador(cliente, reservas);
    }
}
