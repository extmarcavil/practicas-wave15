package ejercicios;

public class Main {
    public static void main(String[] args) {

        Persona facundo = new Persona();
        Persona matias = new Persona("Matias","38383838",24);
        Persona alejandro = new Persona("Alejandro",1.78f,"38393939",74.9f,28);

        if (alejandro.esMayorEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

        System.out.println("Indice de Masa Corporal");
        switch(alejandro.cacularIMC()){
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println("Datos de la persona");
        System.out.println(alejandro.toString());


    }
}

