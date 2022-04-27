package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Estudiantado;
import universidad.interfaces.Soporte;

public class Mantenimiento extends Personal {
    public Mantenimiento(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }
}