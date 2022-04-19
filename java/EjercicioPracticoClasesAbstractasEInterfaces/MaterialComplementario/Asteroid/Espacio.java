package EjercicioPracticoClasesAbstractasEInterfaces.MaterialComplementario.Asteroid;

public abstract class Espacio {
    private int x;
    private int y;
    private String nombre;
    private int puntuacion;

    public Espacio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Espacio(int x, int y, String nombre, int puntuacion) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public Espacio(String nombre) {
        this.nombre = nombre;
    }

    public Espacio() {
    }


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

    @Override
    public String toString() {
        return "Espacio{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
