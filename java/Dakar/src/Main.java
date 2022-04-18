import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carrera carreraAutos = new Carrera(450,300, 5000, "Stage1");
        carreraAutos.ganadorCarrera();
        carreraAutos.darDeAltaAuto(35,2,45,"AB23CD");
        carreraAutos.darDeAltaAuto(45,1,45,"AJ13CD");
        carreraAutos.darDeAltaAuto(65,3,65,"LB73GL");
        carreraAutos.darDeAltaAuto(25,8,75,"YT63CJ");

        carreraAutos.ganadorCarrera();

        System.out.println("ahora eliminamos un vehiculo");

        carreraAutos.eliminarVehiculoConPatente("AB23CD");

        carreraAutos.ganadorCarrera();

        carreraAutos.socorrerAuto("AB23CD");
    }
}