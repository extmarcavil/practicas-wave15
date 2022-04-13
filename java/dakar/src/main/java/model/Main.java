package model;

public class Main {
    public static void main(String[] args) {



        Carrera<Moto> dakar = new Carrera<>(10000,1000000,"Carrera del desierto",20,new SocorristaMoto());

        Moto moto = new Moto(100.0D, 150.0D, 35.0D, "4444");
        dakar.darDeAltaVehiculo(new Moto(100.0D, 150.0D, 35.0D, "ARF305"));
        dakar.darDeAltaVehiculo(new Moto(100.0D, 150.0D, 35.0D, "ARF301"));
        dakar.darDeAltaVehiculo(new Moto(40.0D, 130.0D, 25.0D, "FFA300"));
        dakar.darDeAltaVehiculo(new Moto(40.0D, 130.0D, 25.0D, "FFA302"));
        dakar.darDeAltaVehiculo(moto);
        dakar.socorrerVehiculo("ARF300");

        System.out.println(dakar.determinarGanador());

        for(Object a : dakar.getVehiculos()){
            System.out.println(a);
        }
        System.out.println("--------------------------");
        dakar.eliminarVehiculoConPatente("FFA302");

        for(Object a : dakar.getVehiculos()){
            System.out.println(a);
        }
    }
}
