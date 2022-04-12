package interefaces;

public class Circulo implements FiguraGeometrica {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.pow(radio, 2) * Math.PI;
    }
}
