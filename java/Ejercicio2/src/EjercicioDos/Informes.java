package EjercicioDos;

public class Informes implements Imprimir{
    private int longitudDeTexto, paginas;
    private String autor, revisor;

    public Informes(int longitudDeTexto, int paginas, String autor, String revisor) {
        this.longitudDeTexto = longitudDeTexto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "longitudDeTexto=" + longitudDeTexto +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }


    @Override
    public String imprimir() {
        return toString();
    }
}
