package estructuras;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        String ciudades [] = {"Londres","Madrid","nueva york","bs as","asuncion","sao paulo","lima","santiago de chile","lisboa","tokio"};
        int temperaturas [][] = {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,39,26,31,35}};
        String ciuMenor= "";
        String ciuMayor = "";
        int max = -20;
        int min = 40;

        for(int i=0; i<temperaturas.length; i++){
            for(int j=0; j<temperaturas[i].length; j++){
                if (temperaturas[i][j] < min){
                    min = temperaturas[i][j];
                    ciuMenor = ciudades[j];
                }
                if (temperaturas[i][j] > max){
                    max = temperaturas[i][j];
                    ciuMayor = ciudades[j];
                }
            }
        }

        System.out.println("la ciudad mas caliente es: " + ciuMayor + " con: " + max);
        System.out.println("la ciudad mas fira es: " + ciuMenor + " con: " + min);


    }
}
