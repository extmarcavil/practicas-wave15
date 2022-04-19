import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Localizador> localizadores;

    public Cliente() {
        localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "localizadores=" + localizadores +
                '}';
    }
}
