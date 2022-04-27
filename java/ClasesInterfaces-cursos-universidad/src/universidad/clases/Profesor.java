package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Profesorado;

public class Profesor extends Personal implements Profesorado {
    public Profesor(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }

    @Override
    public void ensenha() {

    }
}