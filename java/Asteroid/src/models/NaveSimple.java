package models;

public class NaveSimple extends Jugador {
    private String nombre;
    private Float x;
    private Float y;

    public NaveSimple(String nombre, Float x, Float y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    @Override
    public Float atacarCoordenadas(Float x, Float y) {
        Float xx = (float) Math.pow(this.x + x, 2);
        Float yy = (float) Math.pow(this.y + y, 2);
        Float res = xx + yy;
        Double ret = Math.sqrt(res);
        return ret.floatValue();
    }

    @Override
    public void imprimirCoordenadasGanadas() {
        System.out.println(this + " " + this.getCoordenadasGanadas());
    }

    @Override
    public String toString() {
        return "NaveSimple{" +
                "nombre='" + nombre + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
