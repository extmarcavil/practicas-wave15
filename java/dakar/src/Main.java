public class Main {

    public static void main(String[] args) {
        Carrera carrera= new Carrera(50,3000,"Carrera1",2,new SocorristaMoto(),new SocorristaAuto());

        carrera.darDeAltaAuto(50,20,4,"auto1");
        carrera.darDeAltaAuto(150,200,40,"auto2");

        carrera.eliminarVehiculoConPatente("auto2");

        carrera.darDeAltaMoto(30,20,2,"moto1");

        carrera.socorrerAuto("auto1");
        carrera.socorrerAuto("auto2");
        carrera.socorrerMoto("moto1");

        System.out.println("El vehiculo ganador es: \n" + carrera.ganador().toString());
    }
}
