package clases_abstractas;

public class Main {

    public static void main(String[] args) {
        FiguraGeometrica c = new Circulo(5);
        System.out.println(c.calcularArea());
        c.getX();
    }
}
