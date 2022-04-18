package repositorio;

import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDrepository<Factura>{

    List<Factura> listaFacturas = new ArrayList<>();

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {

        for(Factura fact : listaFacturas){
            System.out.println(fact.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {

        Boolean bandera = false;
        for(Factura fact : listaFacturas){
            if(fact.getCodigo().equals(codigoBuscado)){
                System.out.println("Factura encontrada, con datos: ");
                System.out.println(fact.toString());
                return Optional.of(fact);
            }
        }
        if(!bandera){
            System.out.println("Factura no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {

        Optional<Factura> fact = this.buscar(codigoBorrado);

        if(fact.isEmpty()){
            System.out.println("No se encontró ninguna factura asociada al código");
        }
        else{
            System.out.println("Factura asociada al código borrada correctamente");
            listaFacturas.remove(fact.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
