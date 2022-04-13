package AgenciaTurismo;

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
        this.paquete = paquete;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String texto= "Localizador:\n"+
                "Paquete:" + paquete.toString() +"\n"+
                "Cliente:" + cliente.toString();
        return texto;
    }
}
