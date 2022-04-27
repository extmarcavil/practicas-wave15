package EjercicioTryCatch;

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {


            try{
                int [] numeros = new int[5];
                numeros[5]=10;
                System.out.println("array");
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                //System.out.println("No se puede, error");
            }

        }

    }

