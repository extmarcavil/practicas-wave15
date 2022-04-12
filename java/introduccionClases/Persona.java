package introduccionClases;

public class Persona {
   // Creá una clase Persona, la cual tendrá los siguientes atributos: nombre, edad,
   // dni (en este caso vamos a representarlo como una cadena de caracteres), peso y altura
   // ¿Qué tipo de dato le asignarías a las variables de instancia? ¿Cómo sería la estructura básica de tu clase?
  // Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, el segundo
   // debe recibir como parámetro nombre, edad y dni; por último creamos un tercero
   // que reciba todos los atributos de la clase como parámetro.
    // Creá una clase nueva llamada Main, donde declares
    // un método main como te enseñamos anteriormente. Esto nos permitirá ejecutar nuestra aplicación.

    // En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees un objeto
    // de tipo Persona por cada constructor que hayamos definido en la clase, recuerda poner un nombre
    // significativo a las variables donde vas a asignar cada objeto. ¿Cómo lo harías? A continuación
    // vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente un valor para el
    // nombre y otro para la edad en el constructor. ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?




    String nombre;
    int edad;
    String dni;
    double peso;
    int altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    // En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para calcularlo es:
    // peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20,
    // la función debe retornar -1, si devuelve un número entre 20 y 25 inclusive para los dos valores, el método
    // debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1. Una vez creado
    // el método anterior, agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano,
    // teniendo en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años.
    // Finalmente agregar un método toString() que va a devolver toda la información de la persona.
    //¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.


    public double calcularIMC(){
        double imc = this.peso / Math.pow(this.altura, 2);

        if(imc < 20){
            return -1;
        }else if(imc >= 20 && imc <=25){
            return 0;
        }else{
            return 1;
        }

    }
    public boolean esMayorDeEdad(){
        if(this.edad > 18){
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
