package IntegradoresP1.AgenciaTurismo;

public class Reserva {
    private String hotel;
    private String comida;
    private String boletosDeViaje;
    private String transporte;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(String boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String str = "";
        if (hotel != null){
            str += "Hotel: " + hotel + ", ";
        }
        if (comida != null){
            str += "Comida: " + comida + ", ";
        }
        if (boletosDeViaje != null){
            str += "Boletos: " + boletosDeViaje + ", ";
        }
        if (transporte != null){
            str += "Transporte: " + transporte;
        }
        return str;
    }

    public boolean isCompleta() {
        return hotel != null && comida != null && boletosDeViaje != null && transporte != null;
    }
}
