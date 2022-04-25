package FigurasGeometricas;

public class Circulo implements FiguraGeo{

    private double radio;

    @Override
    public double calcularArea() {
        double area = Math.PI * (Math.pow(radio, 2));
        return area;
    }

    public Circulo (double radio){
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
