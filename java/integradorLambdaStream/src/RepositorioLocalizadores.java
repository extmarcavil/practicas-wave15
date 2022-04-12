import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private static final RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();
    private List<Localizador> localizadores;

    private RepositorioLocalizadores() {
        localizadores = new ArrayList<>();
    }

    public static RepositorioLocalizadores getRepositorioLocalizadores() { return repositorioLocalizadores; }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
