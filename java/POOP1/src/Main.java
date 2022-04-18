public class Main {
    public static void main(String[] args) {
        Persona lucas = new Persona();
        Persona brian = new Persona("Brian",24,"36681882");
        Persona emmanuel = new Persona("Emmanuel",65,"24323018",85,1.82);

        /*A continuación vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente
          un valor para el nombre y otro para la edad en el constructor.
          ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?
         */
        //No es posible debido a que no declaramos un constructor que acepte esos parametros
        //Persona pepe = new Persona("Pepe",23);


        switch (emmanuel.cacularIMC()){
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

        if(emmanuel.esMayorDeEdad()) System.out.println("Es mayor de edad");
        else System.out.println("No es mayor de edad");

        System.out.println(emmanuel);
    }

}
