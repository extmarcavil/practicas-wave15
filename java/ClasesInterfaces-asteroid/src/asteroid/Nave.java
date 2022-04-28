package asteroid;

public class Nave implements Navegable{

    String nombre;
    int x;
    int y;
    double puntuacion;

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double medirDistancia(int x, int y) {
        double resultado = Math.pow((x-getX()), 2) + Math.pow((y-getY()), 2);
        resultado = Math.sqrt(resultado);
        return resultado;
    }
}
