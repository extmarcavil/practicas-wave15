package models;

import java.util.List;

public class RepositorioCliente {

    RepositorioLocalizador repositorioLocalizador;

    public RepositorioCliente() {
        repositorioLocalizador = new RepositorioLocalizador();
    }

    public Cliente buscarClienteEnRepositorioLocalizador(String dni) {
        Cliente cliente = null;

        for (Localizador r: repositorioLocalizador.getLocalizadores()) {
            if (r.getCliente().getDni().equals(dni)){
                cliente = r.getCliente();
                break;
            }
        }
        return cliente;
    }

    public void agregarClienteEnRepositorioLocalizador(Cliente cliente, List<Reserva> reservas,double total ){
         repositorioLocalizador.agregarLocalizador( new Localizador(cliente,reservas,total));
    }

    public RepositorioLocalizador getRepositorioLocalizador() {
        return repositorioLocalizador;
    }

    public void setRepositorioLocalizador(RepositorioLocalizador repositorioLocalizador) {
        this.repositorioLocalizador = repositorioLocalizador;
    }

    @Override
    public String toString() {
        return "RepositorioCliente{" +
                "repositorioLocalizador=" + repositorioLocalizador +
                '}';
    }

    public void aplicarDescuentosTotales(){
        for (Localizador l: repositorioLocalizador.getLocalizadores()) {
            for (Reserva r: l.getReservas()) {
                //Descuento del 10% para un paquete completo.
                if(r.reservaCompleta()){
                    l.setTotal(l.getTotal()*0.9);
                }
            }
            //Cliente con mas de dos localizadores.
            if(repositorioLocalizador.getLocalizadores().stream().filter(localizador -> localizador.getCliente().getDni().equals(l.getCliente().getDni())).count()>=2){
                l.setTotal(l.getTotal()*0.95);
            }

            // Cliente con mas de dos reservas de hotel o boletos.
            int contadorHotel =0 ;
            int contadorBoletos = 0;

            for (Reserva reserva: l.getReservas()) {
                if(reserva.getHotel() != null){
                    contadorHotel++;
                }
                if (reserva.getBoletosDeViaje() != null){
                    contadorBoletos++;
                }
            }

            if(contadorHotel >= 2 || contadorBoletos>=2){
                l.setTotal(l.getTotal()*0.95);
            }
        }
    }

    public void imprimirLocalizadores(){
        repositorioLocalizador.getLocalizadores().forEach(localizador -> System.out.println(localizador));
    }


}
