public class Main {

    public static void main(String[] args) {
        Localizador localizador = new Localizador();
        Repositorio repo = new Repositorio();
        PaqueteTuristico paquete = new PaqueteTuristico(0);
        paquete.comprarPaqueteCompleto(5000, 1);
        localizador.agregarPaquete(paquete);
        repo.agregarLocalizador(localizador);
        Descuento descuento = new Descuento();
        repo.aplicarDescuentos(descuento);

        System.out.println(paquete.getPrecio());


    }

}
