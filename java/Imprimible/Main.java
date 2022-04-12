package Imprimible;

public class Main {
    public static void main(String[] args) {
        PDF doc1 = new PDF(10, "nombre pdf", "titulo pdf", "pdf pdf");
        String[] habilidades = {"habilidad1", "habilidad2"};
        Curriculum doc2 = new Curriculum("wendy", "sclerandi", 27, habilidades);
        Informe doc3 = new Informe(10, 2,"nombre informe", "revisor");

        IImprimible.imprimir(doc1);
        IImprimible.imprimir(doc2);
        IImprimible.imprimir(doc3);
    }
}
