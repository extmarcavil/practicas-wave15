package ejercicioImpresora;

public interface Imprimible {
    static <T> void imprimir(T documento) {
        System.out.println(documento.toString());
    }
}
