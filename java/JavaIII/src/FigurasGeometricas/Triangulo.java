package FigurasGeometricas;

public class Triangulo extends FiguraGeometrica{

    private int base;
    private int altura;

    @Override
    public double calcularArea() {
        double area = base * altura / 2;
        return area;
    }

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
