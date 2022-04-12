package ejercicio1;

public class ClienteCobrador extends Cliente{
    public ClienteCobrador(boolean tieneDatosEnRegla) {
        super(tieneDatosEnRegla);
    }

    @Override
    public String nombre() {
        return "Cliente Cobrador";
    }

    public void realizarConsultaDeSaldo() {
        ConsultarSaldo nuevaConsulta = new ConsultarSaldo(this);
        nuevaConsulta.imprimirResultado();
    }
}
