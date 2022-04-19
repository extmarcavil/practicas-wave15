package Main;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni;
    private String name;
    private String surname;
    private List<Localizador> localizadorList;

    public Cliente(String dni, String name, String surname) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        localizadorList = new ArrayList<>();
    }

    public boolean descuento(){
        return localizadorList.size() >=2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizador(Localizador localizador) {
        localizadorList.add(localizador);
    }
}
