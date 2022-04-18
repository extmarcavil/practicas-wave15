package integrador.repository;

import integrador.model.Factura;
import integrador.db.SuperMercadoDB;

import java.util.List;
import java.util.stream.Collectors;

public class FacturasRepository implements Repository<Factura,Integer> {
    @Override
    public List<Factura> findAll() {
        return List.copyOf(SuperMercadoDB.getClienteFacturaMap().values());
    }

    @Override
    public Factura find(Integer id) {
        return SuperMercadoDB.getClienteFacturaMap().get(id);
    }

    @Override
    public Factura delete(Integer id) {
        return SuperMercadoDB.getClienteFacturaMap().remove(id);
    }

    @Override
    public Factura insert(Factura factura) {
        return SuperMercadoDB.getClienteFacturaMap().put(factura.getIdFactura(),factura);
    }

    @Override
    public Factura update(Integer id, Factura factura) {
        return SuperMercadoDB.getClienteFacturaMap().put(id,factura);
    }

    public List<Factura> findByClienteDni(Integer dni){
        return SuperMercadoDB.getClienteFacturaMap().values()
                .stream()
                .filter(factura -> factura.getCliente().getDni().equals(dni))
                .collect(Collectors.toList());
    }
}
