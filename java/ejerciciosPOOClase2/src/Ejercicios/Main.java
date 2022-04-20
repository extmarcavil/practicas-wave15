package Ejercicios;

public class Main {

    public static void main(String args[]){
        Persona anonimo = new Persona();
        Persona juan = new Persona("Juan", 20, "12345678");
        Persona pedro = new Persona("Pedro", 30, "12344694", 70, 1.81);

        int imcPedro = pedro.calcularIMC();
        boolean pedroEsMayor = pedro.esMayorDeEdad();
        String informacionDePedro = pedro.toString();

        if(imcPedro < 0){
            System.out.println("Pedro tiene un bajo peso");
        }else if(imcPedro == 0){
            System.out.println("Pedro tiene un peso saludable");
        }else{
            System.out.println("Pedro tiene sobrepeso");
        }

        if(pedroEsMayor){
            System.out.println("Pedro es mayor de edad");
        }else{
            System.out.println("Pedro es menor de edad");
        }

        System.out.println(informacionDePedro);

    }

}
