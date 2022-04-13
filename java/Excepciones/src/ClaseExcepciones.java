public class ClaseExcepciones {

    public static void main(String[] args){
        ClaseExcepciones clase = new ClaseExcepciones();
        int i = clase.calcularCociente();
    }

    int a = 0;
    int b = 300;

    public int calcularCociente(){
        int cociente;
        try{
              cociente = b/a;
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return cociente;
    }
}
