package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Estudiantado;
import universidad.interfaces.Profesorado;

public class Tutor extends Personal implements Estudiantado, Profesorado {
    public Tutor(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }

    @Override
    public void tomaNota() {

    }

    @Override
    public void ensenha() {

    }
}