package ejercicioAgenciaTurismo;

import java.util.ArrayList;

public class PaqueteTuristico {
    private ArrayList<Hotel> hoteles;
    private ArrayList<Comida> comidas;
    private ArrayList<Boleto> boletos;
    private ArrayList<Transporte> transportes;

    public PaqueteTuristico() {
        this.hoteles = new ArrayList<>();
        this.comidas = new ArrayList<>();
        this.boletos = new ArrayList<>();
        this.transportes = new ArrayList<>();
    }

    public double calcularTotal(double descuento) {
        double total = 0;
        if (hoteles.size() >= 2) {
            total += hoteles.stream().mapToDouble(hotel -> hotel.getPrecio() * (1 - 0.05)).sum();
            System.out.println("Aplica descuento de 5% sobre reservas por cantidad de reservas");
        } else {
            total += hoteles.stream().mapToDouble(hotel -> hotel.getPrecio()).sum();
        }
        if (boletos.size() >= 2) {
            total += boletos.stream().mapToDouble(boleto -> boleto.getPrecio() * (1 - 0.05)).sum();
            System.out.println("Aplica descuento de 5% sobre boletos por cantidad de boletos");
        } else {
            total += boletos.stream().mapToDouble(boleto -> boleto.getPrecio()).sum();
        }
        total += comidas.stream().mapToDouble(comida -> comida.getPrecio()).sum();
        return total * (1 - descuento);
    }

    public void addHotel(Hotel hotel) {
        this.hoteles.add(hotel);
    }

    public void addComida(Comida comida) {
        this.comidas.add(comida);
    }

    public void addBoleto(Boleto boleto) {
        this.boletos.add(boleto);
    }

    public void addTransporte(Transporte transporte) {
        this.transportes.add(transporte);
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<Boleto> boletos) {
        this.boletos = boletos;
    }

    public ArrayList<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(ArrayList<Transporte> transportes) {
        this.transportes = transportes;
    }

    public int getReservas() {
        return this.boletos.size() + this.transportes.size() + this.comidas.size() + this.hoteles.size();
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{\n" +
                "\t\tHoteles=" + hoteles.toString() +
                ", \n\t\tComidas=" + comidas.toString() +
                ", \n\t\tBoletos=" + boletos.toString() +
                ", \n\t\tTransportes=" + transportes.toString() +
                "}";
    }
}
