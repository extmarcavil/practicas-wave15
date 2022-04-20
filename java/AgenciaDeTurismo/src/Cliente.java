import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private int dni;
    private int edad;
    private ArrayList<Localizador> localizadores;

    public Cliente(String nombre, int dni, int edad, ArrayList<Localizador> localizadores){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.localizadores = localizadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(ArrayList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }


}
