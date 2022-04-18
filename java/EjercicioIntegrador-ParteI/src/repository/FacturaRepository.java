package repository;

import model.Factura;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements Repository<Factura>{
    List<Factura> facturas;
    public FacturaRepository(){
        facturas = new ArrayList<>();
    }

    @Override
    public Factura save(Factura object) {
        facturas.add(object);
        return object;
    }

    @Override
    public Factura delete(Factura object) {
        try {
            return facturas.remove(facturas.indexOf(object));
        } catch (Exception e){
            System.out.println("No existe la factura: " + object);
        }
        return null;
    }

    @Override
    public Factura deleteByIndex(Integer index) {
        try{
            Factura f = facturas.get(index);
            facturas.remove(index);
            return f;
        } catch (NullPointerException e){
            System.out.println("No existe factura en esta posicion");
        };
        return null;
    }

    @Override
    public List<Factura> findAll() {
        return facturas;
    }

    @Override
    public Factura findByIndex(Integer index) {
        try{
            return facturas.get(index);
        } catch (NullPointerException e){
            System.out.println("No existe factura en esta posicion");
        };
        return null;
    }

    @Override
    public Factura findEquals(Factura object) {
        try {
            return facturas.get(facturas.indexOf(object));
        } catch (Exception e) {
            System.out.println("No existe la factura: " + object);
        }
        return null;
    }

    @Override
    public Factura updateByIndex(Integer index, Factura factura) {
        facturas.set(index, factura);
        return factura;
    }
}
