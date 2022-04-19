package main;

public class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double area;
        area = Math.PI * (radio * radio);
        return area;
    }
}
