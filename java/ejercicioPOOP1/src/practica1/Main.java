package practica1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Luis", 25, "asdfasdfasdf");
        Persona persona3 = new Persona("David", 27,"jsahgvbhxgff", 90.5, 1.82);

        System.out.println(persona3.toString());
        String nivel = "";
        switch (persona3.calcularIMC()){
            case -1:
                nivel="Bajo de Peso";
                break;
            case 0:
                nivel="Peso saludable";
                break;
            case 1:
                nivel="Sobrepeso";
                break;
        }
        System.out.println("El Índice de Masa Corporal: "+nivel);
        if (persona3.esMayorDeEdad()){
            System.out.println("Es Mayor de Edad");
        }
        else {
            System.out.println("No es Mayor de Edad");
        }


    }
}
