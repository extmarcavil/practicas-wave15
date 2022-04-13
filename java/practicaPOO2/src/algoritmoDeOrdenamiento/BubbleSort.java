package algoritmoDeOrdenamiento;

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            System.out.println("Valor de i: " + i);
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    System.out.println("Valor de temp: " + temp);
                    System.out.println("Valor de arr[j-1]: " + arr[j-1]);
                    System.out.println("Valor de arr[j]: " + arr[j]);
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            for (int val : arr) {
                System.out.println(val);
            }

        }

    }
    public static void main(String[] args) {
        int arr[] ={3,60,35,2,45,320,5};

        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSort(arr);//sorting array elements using bubble sort

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}