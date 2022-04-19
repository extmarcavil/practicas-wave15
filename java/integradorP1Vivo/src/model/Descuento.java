package model;

public class Descuento {
    private Integer descuento;
    private String motivo;

    public Descuento(Integer descuento, String motivo) {
        this.descuento = descuento;
        this.motivo = motivo;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Descuento{" +
                "descuento=" + descuento +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
