public class EstudianteTecnico extends Estudiante{
    private String materiaQueColabora;

    public EstudianteTecnico(String nombre, String apellido, String dni, String materiaQueColabora) {
        super(nombre, apellido, dni);
        this.materiaQueColabora = materiaQueColabora;
    }

    public String getMateriaQueColabora() {
        return materiaQueColabora;
    }

    public void setMateriaQueColabora(String materiaQueColabora) {
        this.materiaQueColabora = materiaQueColabora;
    }
}
