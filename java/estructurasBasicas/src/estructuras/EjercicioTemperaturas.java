package estructuras;

public class EjercicioTemperaturas {

    public static void main(String[] args){
        //Declaración vector
        String ciudadedes[] = new String[10];

        //Carga manual vector
        ciudadedes[0] = "Londres";
        ciudadedes[1] = "Madrid";
        ciudadedes[2] = "Nueva York";
        ciudadedes[3] = "Buenos Aires";
        ciudadedes[4] = "Asunción";
        ciudadedes[5] = "São Paulo";
        ciudadedes[6] = "Lima";
        ciudadedes[7] = "Santiago de Chile";
        ciudadedes[8] = "Lisboa";
        ciudadedes[9] = "Tokio";

        //Declaración matriz
        int temperaturas[][] = new int[10][2];
        //Carga manual matriz
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int menorTemperatura = 0, mayorTemperatura = 0;
        int indiceMenor = 0, indiceMayor = 0;

        for(int f = 0; f < temperaturas.length; f++){
            for(int c = 0; c < temperaturas[f].length; c++){
                if (temperaturas[f][0] < menorTemperatura){
                    menorTemperatura = temperaturas[f][0];
                    indiceMenor = f;
                }

                if (temperaturas[f][1] > mayorTemperatura){
                    mayorTemperatura = temperaturas[f][1];
                    indiceMayor = f;
                }
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudadedes[indiceMenor] + ", con " + menorTemperatura + "º C");
        System.out.println("La mayor temperatura la tuvo " + ciudadedes[indiceMayor] + ", con " + mayorTemperatura + "º C");
    }

}
