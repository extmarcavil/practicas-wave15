package abstraccion;

public class Circulo implements FiguraGeometrica {
    private double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Circulo(double radio) {
        super();
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double area;
        area= Math.PI * (radio*radio);
        return  area;
    }
}
