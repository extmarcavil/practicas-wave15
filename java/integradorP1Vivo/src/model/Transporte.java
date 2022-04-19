package model;

import java.time.LocalDate;
import java.util.Date;

public class Transporte extends Reserva{
    private String tipoTransporte;
    private Integer cantidadDiasTransporte;

    public Transporte(Double precio, LocalDate fechaReserva, String tipoTransporte, Integer cantidadDiasTransporte) {
        super(precio, fechaReserva);
        this.tipoTransporte = tipoTransporte;
        this.cantidadDiasTransporte = cantidadDiasTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Integer getCantidadDiasTransporte() {
        return cantidadDiasTransporte;
    }

    public void setCantidadDiasTransporte(Integer cantidadDiasTransporte) {
        this.cantidadDiasTransporte = cantidadDiasTransporte;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "tipoTransporte='" + tipoTransporte + '\'' +
                ", cantidadDiasTransporte=" + cantidadDiasTransporte +
                super.toString() +
                '}';
    }
}
