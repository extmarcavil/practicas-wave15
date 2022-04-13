package Excepciones;

public class PracticaExcepciones {

    private int a;
    private int b;


    public PracticaExcepciones(){
        this.a = 0;
        this.b = 300;
    }

    public PracticaExcepciones(int a, int b){
        this.a = a;
        this.b = b;
    }

    //Punto 1
    //Intento hacer la división. Como conozco los valores de a y b, ya se que va a dar una ArithmeticException.
    /*public void calcularCociente(){
        int resultado = 0;
        try{
            resultado = this.b/this.a;
        }catch (ArithmeticException exception){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }*/

    //Punto 2
    //Pregunto si el divisor que pasé por parámetro será 0, de ser el caso arrojo una IllegalArgumentException.
    public void calcularCociente(){
        try{
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
        }finally{
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String args[]){
        //Llamo al constructor sin parámetros para probar la ArithmeticalException
        //PracticaExcepciones practicaArithmeticException = new PracticaExcepciones();

        //Llamo al constructor pasando por parámetros el dividendo y el divisor para probar la IllegalArgumentException
        PracticaExcepciones practicaIllegalException = new PracticaExcepciones(0, 300);

        //Llamo el método que invoca a las excepciones
        practicaIllegalException.calcularCociente();
    }

}
