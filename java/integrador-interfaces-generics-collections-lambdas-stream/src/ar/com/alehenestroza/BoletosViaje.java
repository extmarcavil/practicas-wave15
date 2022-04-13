package ar.com.alehenestroza;

public class BoletosViaje extends Producto {
    private String destino;
    private String tipoTransporte;

    public BoletosViaje(double costo, String destino, String tipoTransporte) {
        super("BoletosViaje", costo);
        this.destino = destino;
        this.tipoTransporte = tipoTransporte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
