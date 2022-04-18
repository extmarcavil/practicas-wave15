package carreraDeLaSelva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarreraDeLaSelva {
    private Integer participanteNextId = 1;
    private Map<String, ArrayList<Participante>> circuitos;

    public CarreraDeLaSelva() {
        this.circuitos = new HashMap<>();
        this.circuitos.put("chico", new ArrayList<Participante>());
        this.circuitos.put("medio", new ArrayList<Participante>());
        this.circuitos.put("avanzado", new ArrayList<Participante>());
    }

    public void incribirParticipante(String circuito, Participante participante) {
        if (!circuito.equals("avanzado") || participante.getEdad() > 17) {
            this.circuitos.get(circuito).add(participante);
        } else {
            System.out.println("No se puede inscribir");
        }
    }

    public void desinscribirParticipante(String circuito, Participante participante) {
        this.circuitos.get(circuito).remove(participante);
    }

    public void mostrarParticipantesDeCircuito(String circuito) {
        System.out.println("--- Participantes del circuito " + circuito);
        this.circuitos.get(circuito)
                .forEach(p -> System.out.println(p.toString()));
    }

    public void calcularMontos() {
        System.out.println("--- Montos de participanes ");
        this.circuitos.keySet().forEach(key -> {
            System.out.println("- Circuito " + key);
            this.circuitos.get(key).forEach(p -> {
                System.out.println(p.toString());
                System.out.println("{ MONTO: " + p.calcularMonto(key) + " }");
            });
        });
    }
}
