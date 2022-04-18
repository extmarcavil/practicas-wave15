public class Tutor extends Estudiante{
    private String materiaQueEnsena;

    public Tutor(String nombre, String apellido, String dni, String materiaQueEnsena) {
        super(nombre, apellido, dni);
        this.materiaQueEnsena = materiaQueEnsena;
    }

    public String getMateriaQueEnsena() {
        return materiaQueEnsena;
    }

    public void setMateriaQueEnsena(String materiaQueEnsena) {
        this.materiaQueEnsena = materiaQueEnsena;
    }
}
