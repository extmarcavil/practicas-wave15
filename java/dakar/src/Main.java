public class Main {

    public static void main(String[] args) {


        Carrera carrera= new Carrera(50,3000,"Carrera1",2,new SocorristaMoto(),new SocorristaAuto());

        carrera.darDeAltaAuto(50,20,4,"auto");
        carrera.darDeAltaMoto(30,20,2,"moto");

        System.out.println(carrera.ganador().toString());

    }
}
