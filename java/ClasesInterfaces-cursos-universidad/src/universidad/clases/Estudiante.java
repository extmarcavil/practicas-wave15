package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Estudiantado;
import universidad.interfaces.Soporte;

public class Estudiante extends Personal implements Estudiantado {

    public Estudiante(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }

    @Override
    public void tomaNota() {

    }
}