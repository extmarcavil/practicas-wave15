package principal;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

    }
    public Persona(String nombre){

    }
    /*public Persona(String edad){ da errror porque ya tenemos un constructor con la misma cantidad de parametros
                                    y de igual tipo
    }*/

    public  Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    /*En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para calcularlo es:
    peso/(altura^2) - (peso expresado en kg y altura en mts),
    si este cálculo devuelve un valor menor que 20, la función debe retornar -1,

    si devuelve un número entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0, por último,
     si devuelve un número mayor que 25 debe retornar un 1. Una vez creado el método anterior,

      agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano,
      teniendo en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años.
      Finalmente agregar un método toString() que va a devolver toda la información de la persona.
    ¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.
    */

    public int calcularIMC(){
        double imc= this.peso / Math.pow(this.peso, 2) ;
        int rta = 0;

        if(imc < 20){
            rta=-1;
        }else{
            if(imc >= 20 && imc <= 25){
                rta= 0;

            }else{
                if(imc>25){
                    rta =1;
                }
            }
         }
        return rta;
    }

    public boolean esMayoDeEdad(){
       if (this.edad>18){
           return true;
       }
       return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
