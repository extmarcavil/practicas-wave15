package services;

import model.Factura;
import repository.FacturasRepository;

import java.util.List;

public class FacturaService {
    private static final FacturasRepository facturaRepository = new FacturasRepository();

    public void crearFactura(Factura factura){
         facturaRepository.insert(factura);
    }

    public Factura eliminarFactura(Integer idFactura){
        Factura factura=facturaRepository.delete(idFactura);
        if (factura == null) {
            System.out.println("No se encontro ninguna factura con el id "+idFactura);
        }
        else System.out.println("Factura eliminada correctamente");
        return factura;
    }

    public Factura buscarFacturaPorId(Integer idFactura){
        Factura factura=facturaRepository.find(idFactura);
        if (factura == null) {
            System.out.println("No se encontro ninguna factura con el id "+idFactura);
        }
        else System.out.println("Factura encontrada correctamente");
        return factura;
    }

    public List<Factura> listarFacturas(){
        return facturaRepository.findAll();
    }

    public List<Factura> listarFacturasCliente(Integer dni){
        List<Factura> facturas= facturaRepository.findByClienteDni(dni);
        if (facturas == null) {
            System.out.println("No se encontraron facturas para el dni Ingresado");
        }
        else {
            System.out.println("Se encontraron facturas.");
        }
        return facturas;
    }

    public Factura modificarFactura(Integer id,Factura factura){
        return facturaRepository.update(id,factura);
    }

}
