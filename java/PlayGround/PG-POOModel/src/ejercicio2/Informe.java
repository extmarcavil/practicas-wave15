package ejercicio2;

public class Informe extends Documento {

    String text;

    public Informe() {
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n" +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n"+
                " when an unknown printer took a galley of type and scrambled it to make a type\n" +
                " specimen book. It has survived not only five centuries, but also the leap into\n" +
                " electronic typesetting, remaining essentially unchanged. It was popularised in \n" +
                "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,\n" +
                " and more recently with desktop publishing software like Aldus PageMaker including\n" +
                " versions of Lorem Ipsum";
    }

    @Override
    public void imprimir() {
        System.out.println("|---------informe-----------------|");
        System.out.println(text);

    }
}
