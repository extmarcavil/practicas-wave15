package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private final Map<Integer, List<Prenda>> prendasGuardadas;
    private Integer nextId = 1;

    public GuardaRopa() {
        this.prendasGuardadas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendasAguardar) {
        Integer id = this.nextId;
        this.nextId++;
        this.prendasGuardadas.put(id, prendasAguardar);
        return id;
    }

    public List<Prenda> devolverPrendas(Integer id) {
        List<Prenda> prendasAdevolver = this.prendasGuardadas.get(id);
        if (prendasAdevolver != null) {
            this.prendasGuardadas.remove(id);
        }
        return prendasAdevolver;
    }

    public void mostrarPrendas() {
        System.out.println("### Prendas guardadas");
        this.prendasGuardadas.keySet().forEach(k -> {
            System.out.println("# Prendas guardadas con id " + k);
            this.prendasGuardadas.get(k).forEach(Prenda::imprimir);
        });
        System.out.println("---");
    }
}
