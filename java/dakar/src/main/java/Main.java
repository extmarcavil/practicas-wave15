import model.Auto;
import model.Carrera;
import model.Moto;
import model.SocorristaMoto;

public class Main {

    public static void main(String[] args) {

        Carrera<Moto> motoCarrera = new Carrera<>(15, 1000, "Carrera de Moto",
                5, new SocorristaMoto());

        Moto moto = new Moto(100, 150, 35, "4444");

        motoCarrera.darDeAltaVehiculo(new Moto(100, 150, 35, "ARF300"));
        motoCarrera.darDeAltaVehiculo(new Moto(100, 150, 35, "ARF301"));
        motoCarrera.darDeAltaVehiculo(new Moto(40, 130, 25, "FFA300"));
        motoCarrera.darDeAltaVehiculo(new Moto(40, 130, 25, "FFA300"));
        motoCarrera.darDeAltaVehiculo(moto);

        //motoCarrera.eliminarVehiculoConPatente("FFA300");
        motoCarrera.socorrerVehiculo("ARF300");
        motoCarrera.eliminarVehiculo(moto);
        motoCarrera.getVehiculos().forEach(System.out::println);

        //System.out.println(motoCarrera.determinarGanador());
    }
}
