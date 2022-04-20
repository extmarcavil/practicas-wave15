package universidad.clases;

import universidad.abstractas.Personal;
import universidad.interfaces.Estudiantado;
import universidad.interfaces.Soporte;

public class EstudianteTecnico extends Personal implements Estudiantado, Soporte {
    public EstudianteTecnico(String nombre, int edad, String departamento) {
        super(nombre, edad, departamento);
    }

    @Override
    public void tomaNota() {

    }

    @Override
    public void realizaSoporte() {

    }
}
