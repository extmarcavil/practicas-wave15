package EjercicioPracticoPOO;

public class Main {
    public static void main(String[] args) {
        Persona personaSA = new Persona();
        Persona persona3A = new Persona("Miguel", 30 ,"15.555.345-7");
        Persona persona5A = new Persona("Tamara", 29 ,"16.005.435-5", 59.9f,1.60f);

        System.out.println(persona5A);
        if(persona5A.CalcularIMC()==-1){
            System.out.println("Nivel de peso: Bajo peso");
        }else if(persona5A.CalcularIMC()==0){
            System.out.println("Nivel de peso: Adecuado");
        }else if (persona5A.CalcularIMC()==1){
            System.out.println("Nivel de peso: Sobrepeso");
        }

        if (persona5A.EsMayorDeEdad() == true){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}
