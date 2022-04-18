package Abstract;

public class Main {
    public static void main(String[] args) {

         FirugaGeometrica T = new Triangulo(3,4);
         System.out.println("Area del triangulo " + T.calcularArea());

         T = new Circulo(5);
         System.out.println("Area del circulo " + T.calcularArea());
        // este set se crea en circulo.
        //c.setX(5);

    }
}
