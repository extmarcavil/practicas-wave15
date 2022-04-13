package abstracta;

public class Main {
    public static void main(String[] args) {
            Circulo c = new Circulo(14);
            System.out.println("el Circulo tiene un radio de : " + c.calcularArea());

            Triangulo t = new Triangulo(2, 4);
            System.out.println("el Triangulo tiene un area tiene un radio de : " + t.calcularArea());


    }
}
