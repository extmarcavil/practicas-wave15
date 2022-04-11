import java.util.ArrayList;

public class Curriculums  implements  Imprimir {
    private String Nombre;

    private ArrayList<String> ListaHabilidades;

    public  Curriculums(String nombre,ArrayList<String> listaHabilidades){
        this.Nombre = nombre;
        this.ListaHabilidades = listaHabilidades;
    }

    @Override
    public void ImprimirPantalla() {
        System.out.println("Las habilidades de : " + this.Nombre + "\n");
       this.ListaHabilidades.forEach(item -> System.out.println(item.toString()));
    }
}
