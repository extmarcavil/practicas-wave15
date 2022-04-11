public class PracticaExcepciones {
    public int a;
    public  int b;

    public PracticaExcepciones(int A,int B){
        this.a = A;
        this.b = B;
    }

    public  int Calcular() {
        int resultado = 0;
        try {
            resultado =  this.a / this.b;

        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return  resultado;
    }
}
