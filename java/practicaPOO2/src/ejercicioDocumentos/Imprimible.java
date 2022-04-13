package ejercicioDocumentos;

public interface Imprimible<T> {

    static void imprimirDocumento(Documento documento) {
        System.out.println(documento.toString());
    }
}
