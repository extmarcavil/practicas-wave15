package Imprimible;

public class Main {
    public static void main(String[] args) {
        Pdf Doc1 = new Pdf("Libro1", "Lionel Messi", "Cientifico", 500);
        Informe Doc2 = new Informe(20, 50, "AutorInforme", "Revisor1");
        String [] habilidades = {"Habilidad1", "Habilidad2", "Habilidad3"};
        Curriculum Doc3 = new Curriculum("Facundo", "Chaves",50, habilidades);

        IImprimible.imprimir(Doc1);
        IImprimible.imprimir(Doc2);
        IImprimible.imprimir(Doc3);
    }
}
