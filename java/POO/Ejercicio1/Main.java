public class Main {

    public static void main(String[] args) {
        Persona andres = new Persona();
        Persona sofia = new Persona("Sofia", 20, "123456");
        Persona carlos = new Persona("Carlos", 35, "789456", 75.3, 70.4);
        String messageImc;
        int imc = carlos.calcularMC();
        boolean isAdult = carlos.esMayorDeEdad();

        messageImc = "menor que 20";
        if (imc == 0) messageImc = " entre 20 y 25";
        if (imc == 1) messageImc = "mayor que 25";

        System.out.println("La persona " + carlos.getNombre() + ": su IMC es " + messageImc + " la persona es " + (isAdult ? " un adulto" : " un menor de edad"));
    }


}