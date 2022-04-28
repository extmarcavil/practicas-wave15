package asteroid;

public class Participante {
    String nombre;
    Navegable equipo;

    public Participante(String nombre, Navegable equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }
}
