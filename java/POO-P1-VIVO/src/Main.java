public class Main {

    public static void main(String[] args) {
	// write your code here

        Persona personaSinInfo = new Persona();
        Persona personaSinPesoYAltura = new Persona("Belen Tracchia",25,"23456344");
        Persona personaFull = new Persona("Belen Tracchia", 23,"12345678",50.5,1.80);
        int personaIMC = personaFull.calcularIMC();
        System.out.print("El IMC de "+personaFull.nombre + " es ");

        if (personaIMC <0)
        {
            System.out.print("Bajo peso ");
        }else if(personaIMC <1){
            System.out.print("Peso saludable ");
        }else{
            System.out.print("Sobrepeso ");
        }

        if(personaFull.esMayorDeEdad())
        {
            System.out.println("y es mayor de edad.");
        }else{
            System.out.println("Y no es mayor de edad.");
        }

        System.out.println(personaFull.toString());
    }


}
