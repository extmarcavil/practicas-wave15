package abstraccion;

public class Triangulo implements FiguraGeometrica{
    private double base;
    private double altura;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Triangulo(int base, int altura) {
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
            double resultado;
            resultado=(base*altura);
            return resultado;
    }
}
