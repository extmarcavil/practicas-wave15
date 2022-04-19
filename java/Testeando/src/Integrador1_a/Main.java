package Integrador1_a;

public class Main {
    public static int[] burbuja(int[] array) {
        for(int i=0;i<(array.length-1);i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int variableauxiliar=array[i];
                    array[i]=array[j];
                    array[j]=variableauxiliar;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
