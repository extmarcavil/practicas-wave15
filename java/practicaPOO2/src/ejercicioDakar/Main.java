package ejercicioDakar;

public class Main {
    public static void main(String[] args) {

        Auto auto = new Auto(100, 60, 90, "AC 443KLO");
        Auto auto2 = new Auto(100, 50, 90, "AC ITB123");
        Moto moto =  new Moto(100, 90, 160, "AR 221554");
        Moto moto2 = new Moto(120, 100, 280, "AB A21KAN");
        SocorristaMoto socorristaMoto =  new SocorristaMoto();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        Carrera carrera = new Carrera(200, 100000, "Dakar 2022",5, socorristaAuto, socorristaMoto);

        carrera.darDeAltaAuto(auto.getVelocidad(), auto.getAceleracion(), auto.getAnguloDeGiro(), auto.getPatente());
        carrera.darDeAltaAuto(auto2.getVelocidad(), auto2.getAceleracion(), auto2.getAnguloDeGiro(), auto2.getPatente());
        carrera.darDeAltaMoto(moto.getVelocidad(), moto.getAceleracion(), moto.getAnguloDeGiro(), moto.getPatente());
        carrera.darDeAltaMoto(moto2.getVelocidad(), moto2.getAceleracion(), moto2.getAnguloDeGiro(), moto2.getPatente());

        System.out.println(carrera.toString());

        carrera.eliminarVehiculo(moto);
        carrera.eliminarVehiculoConPatente("AC 443KLO");

        System.out.println(carrera.toString());

        carrera.ganadorCarrera();
    }
}
