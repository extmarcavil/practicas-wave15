import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {4,3,5,12,3,42,4324,234,5443};

        boolean sorted = false;
        int e = 0;
        do {
            sorted = true;
            for (int i = 0; i < array.length -  1 ; i++) {
                if (array[i] > array[i+1]) {
                    System.out.println("entra!");
                    int mayor = array[i];
                    int menor = array[i+1];
                    array[i+1] = mayor;
                    array[i] = menor;
                    sorted = false;
                };
            };
            e++;
        } while (!sorted);
        System.out.println(Arrays.toString(array));
    }
}
