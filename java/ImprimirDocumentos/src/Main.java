import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<String> habilidades = new ArrayList<>();
        habilidades.add("Resolución de problemas");
        habilidades.add("Matemática");
        habilidades.add("Trabajo en grupo");

        Curriculum cv = new Curriculum("Francisco Giaccaglia", 21, 43000000, "Córdoba", "Backend dev", habilidades);
        cv.imprimir();

        LibrosPdf libro = new LibrosPdf(350, "J.K Rowling", "Harry Potter", "Mágico");
        libro.imprimir();

        Informe informe = new Informe("En el presente informe me dedicaré a hacer una reseña sobre la película Harry Potter...",
                170, "Francisco Giaccaglia", "Juan Perez");
        informe.imprimir();
    }
}
