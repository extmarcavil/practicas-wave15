package principal;

public class Main {

    public static void main(String[] args) {

        Persona persona= new Persona();
        Persona persona1= new Persona("Carolina",27,"12345");
        Persona persona2= new Persona("Blanca",20,"12345",60.0,1.80);

        infoIMC(persona2);

    }

    public static void  infoIMC(Persona persona){
       int imc= persona.calcularIMC();

       if(imc == -1){
           System.out.println("bajo peso");
       }else{
           if(imc ==0){
               System.out.println("peso saludable");
           }
           else{
               System.out.println("sobrepeso");
           }
       }

    }
}
