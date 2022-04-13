package agenciaViajes.model;

public class Boleto {
    private String destino;
    private int cantidadBoletos;
    private int costo;

    public Boleto(String destino, int cantidadBoletos, int costo) {
        this.destino = destino;
        this.costo = costo;
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
}
