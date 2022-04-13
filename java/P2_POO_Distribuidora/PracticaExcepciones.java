package P2_POO_Distribuidora;

public class PracticaExcepciones {
    int a=0;
    int b=300;
    int resultado=0;
    public void calcularCociente(){
        try{
            resultado= b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
            //System.out.println("Se ah producido un error.");
        }finally {
            System.out.println("Programa finalizado.");
        }
    }

}
