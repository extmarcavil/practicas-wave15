package ar.com.alehenestroza;

import java.util.HashMap;
import java.util.Map;

public class RepositorioFactura implements Repositorio<Integer, Factura> {
    Map<Integer, Factura> facturas;
    Integer contador;

    public RepositorioFactura() {
        this.facturas = new HashMap<>();
        this.contador = 0;
    }

    public Map<Integer, Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Map<Integer, Factura> facturas) {
        this.facturas = facturas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public void mostrarFacturas() {
        this.facturas.forEach((p, q) -> {
            System.out.println("Factura " + p + ":");
            System.out.println(q.toString());
        });
    }

    @Override
    public Integer agregar(Factura factura) {
        Integer facturaId = contador;
        this.facturas.put(facturaId, factura);
        contador++;
        return facturaId;
    }
}
