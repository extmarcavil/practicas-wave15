package ejercicioClaseEnVivo1;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Edgar", 31, "35573378");
        Persona p3 = new Persona("Esteban", 1, "58345678", 12.5f, 0.75f);

        System.out.println(p3.toString());

        if (p3.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }

        System.out.println("Indice de Masa Corporal");
        if (p3.calcularMC() == -1) {
            System.out.println("La persona esta baja de peso");
        } else if (p3.calcularMC() == 0) {
            System.out.println("La persona tiene peso saludable");
        } else {
            System.out.println("La persona esta excedida de peso");
        }

    }
}
