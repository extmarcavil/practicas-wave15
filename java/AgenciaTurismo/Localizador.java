package AgenciaTurismo;

import javax.xml.crypto.dsig.spec.TransformParameterSpec;

public class Localizador {
    private Paquete paquete;
    private Cliente cliente;

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Localizador(Paquete paquete, Cliente cliente) {
        boolean tieneBoleto=paquete.getBoleto().size()!=0;
        boolean tieneComida=paquete.getComida().size()!=0;
        boolean tieneReserva=paquete.getReserva().size()!=0;
        boolean tieneTransporte= paquete.getTransporte() != null;
        double descuento=0;
        if(tieneBoleto && tieneReserva && tieneComida && tieneTransporte){
            descuento=0.10;
        }else if(paquete.getReserva().size()==2 || paquete.getBoleto().size()==2){
            descuento=0.05;
        }
        if(descuento!=0){
            paquete.cargarDescuento(descuento);
        }
        this.paquete = paquete;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador:\n"+
                "Paquete:" + paquete.toString() +"\n"+
                "Cliente:" + cliente.toString();
    }
}
