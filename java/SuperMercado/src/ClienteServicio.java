import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteServicio implements  ICrudGeneral<Cliente>{

    //region Atributos
    List<Cliente> listaClientes;
    //endregion

    //region Constructor

    public ClienteServicio() {
        listaClientes = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public boolean Nuevo(Cliente entity) {
        try{
            listaClientes.add(entity);
        }
        catch (Exception e){
            throw e;
        }
       return  true;
    }

    @Override
    public boolean Eliminar(long Codigo) {
        try{
            listaClientes.remove(this.Buscar(Codigo));
            return  true;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public Cliente Buscar(long Codigo) {
        var where =  listaClientes.stream().filter(f -> f.getDni().equals(Codigo)).collect(Collectors.toList());
        return  where.stream().count() > 0 ? where.get(0) : null;
    }

    @Override
    public boolean Actualizar(Cliente entity) {
        try{
          var idx = listaClientes.indexOf(entity);
          listaClientes.add(idx,entity);
          return true;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Cliente> BuscarTodo() {
        return listaClientes;
    }
    //endregion
}
