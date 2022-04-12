package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        
	/*try{
        FileInputStream file = new FileInputStream("prueba.txt");
    }catch(FileNotFoundException exception){
        exception.printStackTrace();
    }*/
        int[] numeros = new int[5];
        numeros[5] = 10;

        try{
            numeros[5] = 10;
        }catch(ArrayIndexOutOfBoundsException exc){
            System.out.println(exc.getMessage());
        }



    }
}
