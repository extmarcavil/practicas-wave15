package integradora;

public class Informes extends Persona implements Imprimible{
    String texto;
    int cantidadPaginas;
    Persona revisor;

    public Informes(String nombre, String texto, int cantidadPaginas, Persona revisor) {
        super(nombre);
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("---Informe---");
        System.out.println("Autor -> Nombre: " + getNombre());
        System.out.println("Texto: ");
        System.out.println(getTexto());
        System.out.println("Cantidad de páginas: ");
        System.out.println(getCantidadPaginas());
        System.out.println("Revisor-> Nombre: " + revisor.getNombre());
    }
}
