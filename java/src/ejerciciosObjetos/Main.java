package ejerciciosObjetos;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Gonzalo",27,"2317216");
        Persona p3 = new Persona("Gonzalo",27,"2317216",72,182);

        int imc = p3.cacularIMC();
        System.out.print("Índice de masa corporal (IMC): ");
        if(imc < 0){
            System.out.println("Bajo peso");
        }else{
            if(imc == 0)
                System.out.println("Peso saludable");
            else
                System.out.println("Sobrepeso");
        }

        boolean mayorDeEdad = p3.esMayorDeEdad();
        if(mayorDeEdad)
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

        System.out.println(p3.toString());
    }

}
