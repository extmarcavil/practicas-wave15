package ejercicioPOOP1Vivo;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona();
        Persona p2 = new Persona("Juan Perez",23,"12345678");
        Persona p3 = new Persona("Laura Paz", 30, "23456789",61.8f,1.57f);

        //Ejercicio 4: No es posible crear objeto de tipo persona pasando solamente nombre y edad porque no hay un constructor con esos parametros
        //Persona p4 = new Persona("Paula Rodriguez",28);

        int imc = p3.cacularIMC();

        System.out.println("Información de la persona");
        System.out.println("---------------------------");
        System.out.println("Resultado de IMC:");
        switch (imc){
            case -1:
                System.out.println("Tiene bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            default:
                System.out.println("Sobrepeso");
                break;
        }

       if(p3.esMayorDeEdad())
           System.out.println("Es mayor de edad");
       else
           System.out.println("Es menor de edad");

        System.out.println(p3.toString());

    }
}
