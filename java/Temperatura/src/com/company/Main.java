/* Sabiendo que cada índice de fila representa a una ciudad.
Se necesita conocer la mayor y la menor temperatura entre todas las ciudades;
al mismo tiempo se deberá especificar el nombre de la ciudad.
Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.
 **/

package com.company;

public class Main {


    public static void main(String[] args) {

        int auxMax=0,auxMin=0,max=0,min=0;

        String cities[] = new String[10];
        int temp[][] = new int[2][10];

        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        temp[0][0] = 33; temp[1][0] = -2;
        temp[0][1] = 32; temp[1][1] = -3;
        temp[0][2] = 27; temp[1][2] = -8;
        temp[0][3] = 37; temp[1][3] = 4;
        temp[0][4] = 42; temp[1][4] = 6;
        temp[0][5] = 43; temp[1][5] = 5;
        temp[0][6] = 39; temp[1][6] = 0;
        temp[0][7] = 26; temp[1][7] = -7;
        temp[0][8] = 31; temp[1][8] = -1;
        temp[0][9] = 35; temp[1][9] = -10;

        for (int i = 0; i < cities.length; i++) {
            if(temp[0][i]>=max){
                auxMax=i;
                max=temp[0][i];
            }
            if(temp[1][i]<=min){
                min=temp[1][i];
                auxMin=i;
            }
        }
        System.out.println("En la ciudad "+ cities[auxMax] + " esta la mayor temperatura: " + max);
        System.out.println("En la ciudad "+ cities[auxMin] + " esta la mayor temperatura: " + min);
    }
}
