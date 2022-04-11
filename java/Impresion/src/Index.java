import java.util.ArrayList;

public class Index {
    public static void main(String[] args) {
        var listaHabilidades = new ArrayList<String>();
        listaHabilidades.add("Responsable");
        listaHabilidades.add("Trabajo en equipo");
        listaHabilidades.add("Autodidacta");
        listaHabilidades.add("Puntualidad");
        var curriculums = new Curriculums("Gerson",listaHabilidades);
        curriculums.ImprimirPantalla();

        var libros = new LibrosPDF(34,"Homero","La oidesa","Epopeya");
        libros.ImprimirPantalla();

        var Informes = new Informes("es un texto de prueba",1,"Gerson","Martìn");
        Informes.ImprimirPantalla();
    }
}
