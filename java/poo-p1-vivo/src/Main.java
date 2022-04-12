public class Main {

    public static void main(String[] args) {
        Persona alejandro = new Persona();
        Persona pedro = new Persona("Pedro", 30, "12345678910");
        Persona veronica = new Persona("Veronica", 25, "01987654321", 61.3, 1.72);

        // Cantidad de parametros invalida
//        Persona marcos = new Persona("Marcos", 26);

        System.out.println(veronica);

        System.out.println(veronica.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad");

        switch (veronica.calcularIMC()) {
            case -1:
                System.out.println("IMC: Bajo peso");
                break;
            case 0:
                System.out.println("IMC: Peso saludable");
                break;
            case 1:
                System.out.println("IMC: Sobrepeso");
                break;
        }
    }
}
