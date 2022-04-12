package ejercicio2;

public class Informe implements Imprimir{

    public String texto;
    public int longitud;
    public int cantPag;
    public String autor;
    public String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", longitud=" + longitud +
                ", cantPag=" + cantPag +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(texto + " " + longitud + " " + cantPag + " " + autor + " " + revisor);

    }
}
