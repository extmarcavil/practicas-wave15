package Abstract;

public class Triangulo implements FirugaGeometrica {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double area;
        area = (base * altura) / 2;
        return area ;
    }
}
