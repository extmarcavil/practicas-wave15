import reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nombre;
    List<Localizador> localizadores;

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
