package ejercicioImpresora;

public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Edgar", "Ocampo");
        LibroPDF libro = new LibroPDF(25, "jose garcia", "El arte de volar", "Fantasia");
        Informe informe = new Informe("Hola, este es un nuevo texto", 10, "Anonimo", "Anonimo");

        Imprimible.imprimir(cv);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}
