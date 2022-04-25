package FigurasGeometricas;

public abstract class FiguraGeometrica {
    private int x;
    private int y;

    public abstract double calcularArea();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
