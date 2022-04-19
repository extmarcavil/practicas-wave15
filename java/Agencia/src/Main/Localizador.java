package Main;

import java.util.HashMap;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double totalPrice;
    private List<Reserva> reservas;

    public Localizador(){}

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        //TODO calculo del total
        totalPrice =  reservas.stream().mapToDouble(r -> r.getPrice()).sum();
        if(cliente.descuento()){
            totalPrice = totalPrice * 0.95;
        }

        int cantHotel = 0;
        int cantViajes = 0;
        boolean[] unoDeCadaUno = {false, false, false, false};


        for (int i = 0; i < reservas.size(); i++){

            if(reservas.get(i).getClass().getSimpleName().compareTo("Hotel") == 0){
                cantHotel++;
                unoDeCadaUno[0] = true;
                continue;
            }
            if(reservas.get(i).getClass().getSimpleName().equals("Comida")){
                unoDeCadaUno[1] = true;
                continue;
            }
            if(reservas.get(i).getClass().getSimpleName().equals("Viaje")){
                cantViajes++;
                unoDeCadaUno[2] = true;
                continue;
            }
            if(reservas.get(i).getClass().getSimpleName().equals("Transporte")){
                unoDeCadaUno[3] = true;
                continue;
            }
        }
        if(cantHotel > 1 && cantViajes > 1){
            totalPrice = totalPrice * 0.95;
        }

        if(
                unoDeCadaUno[0] &&
                unoDeCadaUno[1] &&
                unoDeCadaUno[2] &&
                unoDeCadaUno[3]
        ){
            totalPrice = totalPrice * 0.90;
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
