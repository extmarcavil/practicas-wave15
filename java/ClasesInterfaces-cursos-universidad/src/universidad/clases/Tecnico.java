package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Estudiantado;
import universidad.interfaces.Soporte;

public class Tecnico extends Personal implements Soporte {
    public Tecnico(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }

    @Override
    public void realizaSoporte() {

    }
}