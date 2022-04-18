package supermercadoElEconomico;

import java.util.Optional;

public interface CRUDRepository <T>{

    public void guardar(T object);
    public void consultar();
    public T buscar(int id);
    public void eliminar();

}
