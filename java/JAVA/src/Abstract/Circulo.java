package Abstract;

public class Circulo implements FirugaGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }


    public double calcularArea() {
        return Math.PI * (radio*radio);
    }
}
