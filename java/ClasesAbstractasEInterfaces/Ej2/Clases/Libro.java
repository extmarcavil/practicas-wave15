package ClasesAbstractasEInterfaces.Ej2.Clases;

public class Libro {

    private String titulo;
    private String autor;
    private String genero;
    private int paginas;

    public Libro(String titulo, String autor, String genero, int paginas){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ").append(getTitulo()).append("\n");
        sb.append("Autor: ").append(getAutor()).append("\n");
        sb.append("Genero: ").append(getGenero()).append("\n");
        sb.append("Paginas: ").append(getPaginas()).append("\n");
        return sb.toString();
    }
}
