package ejercicioAgenciaTurismo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Repositorio {
    private ArrayList<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public ArrayList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public boolean validarLocalizadoresCliente(Cliente cliente) {
        if (localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList()).size() >= 2) {
            return true;
        }
        return false;
    }

    public boolean validarPaqueteCompleto(PaqueteTuristico paquete) {
        if (!paquete.getHoteles().isEmpty() &&
                !paquete.getComidas().isEmpty() &&
                !paquete.getBoletos().isEmpty() &&
                !paquete.getTransportes().isEmpty()){
            return true;
        }
        return false;
    }

    public void addLocalizador(Localizador localizador) {
        double descuento = 0;
        if (validarLocalizadoresCliente(localizador.getCliente())) {
            descuento += 0.05;
            System.out.println("Aplica descuento del 5% por cantidad de localizadores");
        }
        if (validarPaqueteCompleto(localizador.getPaquete())) {
            descuento += 0.1;
            System.out.println("Aplica descuento del 10% por paquete completo");
        }
        localizador.calcularTotal(descuento);
        this.localizadores.add(localizador);
        System.out.println(localizador);
    }


}
