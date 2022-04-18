import models.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Asteroid {
    List<Jugador> jugadores;

    public Asteroid() {
        this.jugadores = new ArrayList<>();
    }

    public void addJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void iniciarJuego(List<List<Float>> listaCoordenadas) {
        listaCoordenadas.forEach(coords -> {
            Float x = coords.get(0);
            Float y = coords.get(1);
            Jugador jugador = this.jugadores
                    .stream()
                    .reduce(null, (acc, j) ->
                        acc == null
                                ? j
                                : ganadorEntre(acc, j, x, y)
                    );
            jugador.addPuntuacion(1);
            jugador.addCoordenadaGanada(coords);
        });
        imprimirGanador();
        imprimirPuntajes();
    }

    private void imprimirPuntajes() {
        System.out.println("Puntajes");
        this.jugadores.forEach(Jugador::imprimirCoordenadasGanadas);
    }

    private void imprimirGanador() {
        System.out.println("--- El ganador del juego es ---");
        Jugador jugador = this.jugadores
                .stream()
                .reduce(null, (acc, j) ->
                        acc == null
                                ? j
                                : masPuntosEntre(acc, j)
                );
        System.out.println(jugador);
        System.out.println("");
    }

    private Jugador masPuntosEntre(Jugador j1, Jugador j2) {
        return j1.getPuntuacion() >= j2.getPuntuacion()
                ? j1
                : j2;
    }

    private Jugador ganadorEntre(Jugador j1, Jugador j2, Float x, Float y) {
        return j1.atacarCoordenadas(x, y) <= j2.atacarCoordenadas(x, y)
                ? j1
                : j2;
    }
}
