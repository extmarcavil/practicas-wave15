package principal;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }
        public static void calcularMontoFactura() {
            List<String> mensajeStrings = new LinkedList<>();

            int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios

            double totalFactura=0;
            //Tu codigo aqui
            for (int i = 0; i < serviciosCli.length ; i++) {


                if (serviciosCli[i]==1) {
                    totalFactura= 1500;
                    System.out.println("El monto de la factura es de: " + totalFactura);
                }
                else {
                    totalFactura= 1500+700;
                    System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                    System.out.println("El monto de la factura es de: " + totalFactura);
                }
            }

            int[] numeros = new int[5];
            try{
                numeros[5] = 10;
            }catch(ArrayIndexOutOfBoundsException exc){
                exc.getMessage();
            }


        }

}


