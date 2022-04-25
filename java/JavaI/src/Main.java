public class Main {

    public static void main(String args[]) {
        String [] cities = new String[] {"Londres","Madrid", "Nueva York","Buenos Aires","Asuncion","San Pablo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [][] temps = new int [][] {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int minTemp = Integer.MAX_VALUE;
        int minIndex = 0;

        int maxTemp = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < cities.length; i++){
            if (temps[i][0] < minTemp){
                minIndex = i;
                minTemp = temps [i][0];
            }
            if (temps[i][1] > maxTemp){
                maxIndex = i;
                maxTemp = temps [i][1];
            }
        }

        System.out.println("La menor temperatura fue " + temps[minIndex][0] + "°C y fue registrada en " + cities[minIndex]);
        System.out.println("La mayor temperatura fue " + temps[maxIndex][1] + "°C y fue registrada en " + cities[maxIndex]);
    }
}
