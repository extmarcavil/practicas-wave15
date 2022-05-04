public class Ejercicio {
    public static void main(String[] args) {
        String[] lugares = new String[10];
        lugares[0] = "Londres";
        lugares[1] = "Madrid";
        lugares[2] = "Nueva York";
        lugares[3] = "Buenos Aires";
        lugares[4] = "Asunción";
        lugares[5] = "São Paulo";
        lugares[6] = "Lima";
        lugares[7] = "Santiago de Chile";
        lugares[8] = "Lisboa";
        lugares[9] = "Tokio";

        int[][] clima = new int[10][2];
        clima[0][0] = -2;
        clima[0][1] = 33;
        clima[1][0] = -3;
        clima[1][1] = 32;
        clima[2][0] = -8;
        clima[2][1] = 27;
        clima[3][0] = 4;
        clima[3][1] = 37;
        clima[4][0] = 6;
        clima[4][1] = 42;
        clima[5][0] = 5;
        clima[5][1] = 43;
        clima[6][0] = 0;
        clima[6][1] = 39;
        clima[7][0] = -7;
        clima[7][1] = 26;
        clima[8][0] = -1;
        clima[8][1] = 31;
        clima[9][0] = -10;
        clima[9][1] = 35;

        int indiceMin = 0, indiceMax = 0;

        for (int i = 0; i < 10; i++) {
            if (clima[indiceMin][0] > clima[i][0]) {
                indiceMin = i;
            }
            if (clima[indiceMax][1] < clima[i][1]) {
                indiceMax = i;
            }
        }

        System.out.println("La temperatura minima fue de " + clima[indiceMin][0] + "º en " + lugares[indiceMin]);
        System.out.println("La temperatura maxima fue de " + clima[indiceMax][1] + "º en " + lugares[indiceMax]);
    }
}
