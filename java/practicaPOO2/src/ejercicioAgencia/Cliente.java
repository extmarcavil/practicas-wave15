package ejercicioAgencia;

import java.util.ArrayList;

public class Cliente {
    private long dni;
    private String nombre;
    private ArrayList<Localizador> localizadores;

    public Cliente(long dni, String nombre, ArrayList<Localizador> localizadores) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = localizadores;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(ArrayList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", localizadores=" + localizadores +
                '}';
    }
}
