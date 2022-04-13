package Clases;

public class Main {
    public static void main(String[] args) {

        //Persona persona = new Persona();
        //Persona persona1 = new Persona("Francisco", 20, "43227665");
        Persona persona2 = new Persona("Francisco", 21, "43227665", 60, 1.72);

        String info = persona2.stringInfo();
        System.out.println(info);
    }
}
