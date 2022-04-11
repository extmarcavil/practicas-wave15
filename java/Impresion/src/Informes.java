public class Informes implements Imprimir {
    private  String Texto;

    private int CantidadPaginas;

    private  String Autor;

    private String Revisor;

    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
        Texto = texto;
        CantidadPaginas = cantidadPaginas;
        Autor = autor;
        Revisor = revisor;
    }

    @Override
    public void ImprimirPantalla() {
        System.out.println("Texto es:" + this.Texto + "\n" +
                "Autor " + this.Autor + "\n" +
                "Revisor " + this.Revisor + "\n" +
                "Cantidad de Paginas " + this.CantidadPaginas);
    }
}


