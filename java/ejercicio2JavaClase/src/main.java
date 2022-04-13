import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int nota1, nota2, nota3;
        float promedio;

        System.out.println("Ingrese la primer nota: ");
        Scanner teclado = new Scanner(System.in);
        nota1 = teclado.nextInt();
        System.out.println("Ingrese la segunda nota: ");
        Scanner teclado2 = new Scanner(System.in);
        nota2 = teclado2.nextInt();
        System.out.println("Ingrese la tercer nota: ");
        Scanner teclado3 = new Scanner(System.in);
        nota3 = teclado3.nextInt();

        promedio = (nota1+nota2+nota3) / 3;

        if (promedio <= 4){
            System.out.println("El alumno desaprobó");
        }
        else{
            if(promedio <= 6){
                System.out.println("El alumno va a diciembre");
            }
            else{
                System.out.println("El alumno aprobó");
            }
        }

    }

}
