package EjercicioDos;

public class Curriculum extends Persona implements Imprimir{

    public Curriculum(String nombre, List<String> skill) {
        super(nombre, skill);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", skill=" + skill +
                '}';
    }


    @Override
    public String imprimir() {
        return toString();
    }
}
