package AgenciaTurismo;

import java.util.ArrayList;

public class Paquete {

    private ArrayList<Comida> comida;
    private ArrayList<Boleto> boleto;
    private ArrayList<ReservaHotel> reserva;
    private Transporte transporte;
    private double total;

    @Override
    public String toString() {
        return "Paquete{" +
                "comida=" + comida +
                ", boleto=" + boleto +
                ", reserva=" + reserva +
                ", transporte=" + transporte +
                ", Total: "+ total +"}";
    }

    public Paquete() {
        comida = new ArrayList<>();
        boleto = new ArrayList<>();
        reserva = new ArrayList<>();
    }

    public ArrayList<Comida> getComida() {
        return comida;
    }

    public void setComida(ArrayList<Comida> comida) {
        this.comida = comida;
    }

    public ArrayList<Boleto> getBoleto() {
        return boleto;
    }

    public void setBoleto(ArrayList<Boleto> boleto) {
        this.boleto = boleto;
    }

    public ArrayList<ReservaHotel> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<ReservaHotel> reserva) {
        this.reserva = reserva;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public void getTotal(){
        total=this.boleto.stream().mapToDouble(Boleto::getPrecio).sum()+
                this.transporte.getPrecio()+
                this.reserva.stream().mapToDouble(ReservaHotel::getPrecio).sum()+
                this.comida.stream().mapToDouble(Comida::getPrecio).sum();
    }
    public void cargarDescuento(double descuento){
        total-=total*descuento;
    }
}
