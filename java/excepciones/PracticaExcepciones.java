package excepciones;

public class PracticaExcepciones {
    private int a=0;
    private int b=300;
    public void cociente (){
        try{
            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            System.out.println(b/a);
        }catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
        System.out.println("programa finalizado");
    }
}
