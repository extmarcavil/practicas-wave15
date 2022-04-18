package Modelo;

import Repositorios.Servicio;

public class BoletosDeViajes extends Servicio {

    private String destino;
    private String tipoDeTransporte;

    public BoletosDeViajes(double valor, String destino, String tipoDeTransporte) {
        super("Boletos de viaje", valor);
        this.destino = destino;
        this.tipoDeTransporte = tipoDeTransporte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoDeTransporte() {
        return tipoDeTransporte;
    }

    public void setTipoDeTransporte(String tipoDeTransporte) {
        this.tipoDeTransporte = tipoDeTransporte;
    }

    @Override
    public String toString() {
        return "BoletosDeViajes{" +
                "destino='" + destino + '\'' +
                ", tipoDeTransporte='" + tipoDeTransporte + '\'' +
                '}';
    }
}
